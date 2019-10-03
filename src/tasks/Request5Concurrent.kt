package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import kotlinx.coroutines.coroutineScope

suspend fun loadContributorsConcurrent(
    service: GitHubService,
    req: RequestData
): List<User> = coroutineScope {

    TODO()
//    val deferreds: List<Deferred<List<User>>> = repos.map { repo ->
//        async {
//            val users = ...
//            ...
//            users
//        }
//    }
//    deferreds.awaitAll()
}