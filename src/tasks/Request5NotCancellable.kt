package tasks

import contributors.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

suspend fun loadContributorsNotCancellable(
    service: GitHubService,
    req: RequestData
): List<User> {

    val repos = service
        .getOrgRepos(req.org)
        .also { logRepos(req, it) }
        .bodyList()

    val deferredUsers: List<Deferred<List<User>>> = repos.map { repo ->
        GlobalScope.async {
            service.getRepoContributors(req.org, repo.name)
                .also { logUsers(repo, it) }
                .bodyList()
        }
    }

    return deferredUsers
        .awaitAll()
        .flatten()
        .aggregate()

}