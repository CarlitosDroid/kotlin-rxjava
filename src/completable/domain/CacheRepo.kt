package completable.domain

import completable.domain.model.User
import io.reactivex.Completable

interface CacheRepo {
    fun saveUserData(user: User): Completable
}