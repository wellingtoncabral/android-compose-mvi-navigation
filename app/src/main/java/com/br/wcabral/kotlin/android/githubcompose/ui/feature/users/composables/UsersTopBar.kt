package com.br.wcabral.kotlin.android.githubcompose.ui.feature.users.composables

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.br.wcabral.kotlin.android.githubcompose.R

@Composable
fun UsersTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.users_screen_top_bar_title)) }
    )
}

@Preview(showBackground = true)
@Composable
fun ReposTopBarPreview() {
    UsersTopBar()
}