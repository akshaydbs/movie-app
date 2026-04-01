package com.development.movie.data.mapper

import com.development.movie.data.model.MovieDto
import com.development.movie.domain.Movie


fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id ?: -1,
        title = title ?: originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = posterPath,
        releaseDate = releaseDate,
        rating = voteAverage ?: 0.0
    )
}