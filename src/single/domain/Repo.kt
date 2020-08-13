package single.domain

import io.reactivex.Single
import single.data.model.SeriesResponse

interface Repo {
    fun getShowDetails(): Single<SeriesResponse>
}