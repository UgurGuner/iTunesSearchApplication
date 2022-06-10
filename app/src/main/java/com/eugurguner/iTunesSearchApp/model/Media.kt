package com.eugurguner.iTunesSearchApp.model

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

enum class EntityType(val value: String) {
    Movies("movie"),
    Music("song"),
    Apps("software"),
    Books("ebook"),
    None("")
}

data class Media(
    @SerializedName("collectionId") val id: Int,
    val wrapperType: String?,
    val artworkUrl100: String?,
    val collectionPrice: Double?,
    val trackPrice: Double?,
    val price: Double?,
    val collectionName: String?,
    val releaseDate: String?,
    val trackName: String?,
    val trackCount: Int?,
    val trackNumber: Int?,
    val artistName: String?,
) {

    fun getFilledTitle(): String {
        return collectionName ?: trackName ?: ""
    }

    fun getCollectionPrice(): String {
        return if ((collectionPrice ?: 0.0) == 0.0) "" else "${collectionPrice}$"
    }

    fun getTrackPrice(): String {
        return if ((trackPrice ?: 0.0) == 0.0) "" else "${trackPrice}$"
    }

    fun getPrice(): String {
        return if ((price ?: 0.0) == 0.0) "" else "${price}$"
    }

    fun formatReleaseDate(): String {

        if (releaseDate.isNullOrEmpty()) return ""

        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")

        return OffsetDateTime.parse(releaseDate).format(formatter)

    }

}