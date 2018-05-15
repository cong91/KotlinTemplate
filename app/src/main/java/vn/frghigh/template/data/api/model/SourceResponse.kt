package vn.frghigh.template.data.api.model

import com.squareup.moshi.Json


data class SourceResponse(
        @Json(name = "status") var status: String?, //ok
        @Json(name = "sources") var sources: List<Source>
)

data class Source(
        @Json(name = "id") var id: String, //abc-news-au
        @Json(name = "name") var name: String?, //ABC News (AU)
        @Json(name = "description") var description: String?, //Australia's most trusted source of local, national and world news. Comprehensive, independent, in-depth analysis, the latest business, sport, weather and more.
        @Json(name = "url") var url: String?, //http://www.abc.net.au/news
        @Json(name = "category") var category: String?, //general
        @Json(name = "language") var language: String?, //en
        @Json(name = "country") var country: String? //au
)