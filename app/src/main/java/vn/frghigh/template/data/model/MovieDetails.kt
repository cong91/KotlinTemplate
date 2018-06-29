/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vn.frghigh.template.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import vn.frghigh.template.utils.extension.empty
@Entity(tableName = "movie_details")
data class MovieDetails(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int,
        @ColumnInfo(name = "title")
        val title: String,
        @ColumnInfo(name = "poster")
        val poster: String,
        @ColumnInfo(name = "summary")
        val summary: String,
        @ColumnInfo(name = "cast")
        val cast: String,
        @ColumnInfo(name = "director")
        val director: String,
        @ColumnInfo(name = "year")
        val year: Int,
        @ColumnInfo(name = "trailer")
        val trailer: String) {

    companion object {
        fun empty() = MovieDetails(0, String.empty(), String.empty(), String.empty(),
                String.empty(), String.empty(), 0, String.empty())
    }
}
