package com.br.wcabral.kotlin.android.githubcompose.ui.feature.repos.composables

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.br.wcabral.kotlin.android.githubcompose.R
import com.br.wcabral.kotlin.android.githubcompose.data.model.User
import com.br.wcabral.kotlin.android.githubcompose.data.model.UserPreview
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.common.RoundedImage
import com.br.wcabral.kotlin.android.githubcompose.ui.theme.OnSurfaceBackgroundAlpha
import com.br.wcabral.kotlin.android.githubcompose.ui.theme.OnSurfaceTextAlpha
import java.util.*

@Composable
fun ReposListHeader(user: User) {
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)
    val paddingXSmall = dimensionResource(id = R.dimen.padding_xsmall)

    Column{
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingMedium)
        ) {
            ScoreSession(user)

            Spacer(modifier = Modifier.size(paddingXSmall))

            UserDetailSession(user)

            Spacer(modifier = Modifier.size(paddingMedium))

            ButtonsSession(user)
        }

        Divider(
            thickness = paddingMedium,
            color = MaterialTheme.colors.onSurface.copy(alpha = OnSurfaceBackgroundAlpha)
        )
    }
}

@Composable
fun ScoreSession(user: User) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        RoundedImage(
            url = user.avatarUrl,
            placeholder = R.drawable.avatar_placeholder,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.avatar_size_large))
                .padding(end = dimensionResource(id = R.dimen.padding_medium))
        )

        ScoreItem(count = user.publicRepos, description = stringResource(R.string.repos_score_title))
        ScoreItem(count = user.followers, description = stringResource(R.string.followers_score_title))
        ScoreItem(count = user.following, description = stringResource(R.string.following_score_title))
    }
}

@Composable
fun UserDetailSession(user: User) {
    Text(
        text = user.name,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = user.location ?: stringResource(R.string.location_not_defined),
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.onSurface.copy(alpha = OnSurfaceTextAlpha)
    )
}

@Composable
fun ButtonsSession(user: User) {
    // See all button
    val context = LocalContext.current
    val profileIntent = remember{ Intent(Intent.ACTION_VIEW, Uri.parse(user.htmlUrl)) }
    val blogIntent = remember{ Intent(Intent.ACTION_VIEW, Uri.parse(user.blogUrl)) }

    // View Blog
    val blogNotFoundDialog = remember { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = {
            context.startActivity(profileIntent)
        }) {
            Text(text = stringResource(R.string.button_see_all_title))
        }

        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_small)))

        OutlinedButton(onClick = {
            if (user.blogUrl.isEmpty()) {
                blogNotFoundDialog.value = true
            } else {
                context.startActivity(blogIntent)
            }
        }) {
            Text(text = stringResource(R.string.button_view_blog_title))
        }
    }

    if (blogNotFoundDialog.value) {
        AlertDialog(onDismissRequest = {
            blogNotFoundDialog.value = false
        },
            title = {
                Text(text = stringResource(R.string.blog_not_found_dialog_title))
            },
            text = {
                Text(text = stringResource(R.string.blog_not_found_dialog_text))
            },
            confirmButton = {
                Text(text = stringResource(R.string.blog_not_found_dialog_confirm_button).uppercase(
                    Locale.getDefault()
                ))
            })
    }
}

@Composable
fun ScoreItem(count: Int, description: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.onSurface.copy(alpha = OnSurfaceTextAlpha)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReposUserDetailPreview() {
    ReposListHeader(user = UserPreview.user)
}
