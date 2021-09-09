package com.br.wcabral.kotlin.android.githubcompose.ui.feature.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.br.wcabral.kotlin.android.githubcompose.R

@Composable
fun RoundedImage(
    url: String,
    @DrawableRes placeholder: Int,
    modifier: Modifier = Modifier,
    crossfade: Boolean = true,
) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                crossfade(crossfade)
                placeholder(placeholder)
                transformations(CircleCropTransformation())
            }
        ),
        contentDescription = null,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun RoundedImagePreview() {
    RoundedImage(
        url = "",
        placeholder = R.drawable.avatar_placeholder,
        modifier = Modifier.size(dimensionResource(id = R.dimen.avatar_size_medium))
    )
}