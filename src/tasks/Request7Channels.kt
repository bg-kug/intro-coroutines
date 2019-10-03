package tasks

import contributors.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun loadContributorsChannels(
    service: GitHubService,
    req: RequestData,
    updateResults: suspend (List<User>, completed: Boolean) -> Unit
) {
    coroutineScope {

        TODO()
//
//        val channel = Channel<List<User>>()
//
//        for (repo in repos) {
//            launch {
//                val users = ...
//                // ...
//                channel.send(users)
//            }
//        }
//        repeat(repos.size) {
//            val users = channel.receive()
//            ...
//        }

    }
}
