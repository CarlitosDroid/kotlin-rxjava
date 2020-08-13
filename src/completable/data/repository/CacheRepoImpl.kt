package completable.data.repository

import completable.data.CacheService
import completable.domain.CacheRepo
import completable.domain.model.User
import io.reactivex.Completable

class CacheRepoImpl(private val cacheService: CacheService): CacheRepo {
    override fun saveUserData(user: User): Completable {
        return Completable.fromAction {
            cacheService.saveUser(user)
        }
    }
}