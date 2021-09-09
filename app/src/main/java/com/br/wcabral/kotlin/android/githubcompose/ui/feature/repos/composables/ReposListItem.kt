package com.br.wcabral.kotlin.android.githubcompose.ui.feature.repos.composables

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CallSplit
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.br.wcabral.kotlin.android.githubcompose.R
import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.RepoPreview
import com.br.wcabral.kotlin.android.githubcompose.ui.theme.OnSurfaceTextAlpha
import java.util.*

@Composable
fun ReposListItem(repo: Repo) {
    val paddingXXSmall = dimensionResource(id = R.dimen.padding_xxsmall)
    val paddingSmall = dimensionResource(id = R.dimen.padding_small)
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)

    val context = LocalContext.current
    val visitRepoIntent = remember{ Intent(Intent.ACTION_VIEW, Uri.parse(repo.htmlUrl)) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { context.startActivity(visitRepoIntent) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingMedium)
        ) {
            Column {
                Text(
                    text = repo.name,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.size(paddingXXSmall))

                Text(
                    text = repo.description ?: stringResource(R.string.no_description_informed),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface.copy(alpha = OnSurfaceTextAlpha),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.size(paddingSmall))

                Text(
                    text = repo.language?.uppercase(Locale.getDefault())
                        ?: stringResource(R.string.language_not_defined),
                    style = MaterialTheme.typography.subtitle2,
                )

                Spacer(modifier = Modifier.size(paddingMedium))

                CounterSession(repo = repo)
            }
        }
        Divider()
    }
}

@Composable
fun CounterSession(repo: Repo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CounterItem(icon = Icons.Outlined.Visibility, counterText = repo.watchersCount.toString())
        CounterItem(icon = Icons.Outlined.StarBorder, counterText = repo.stargazersCount.toString())
        CounterItem(icon = Icons.Outlined.CallSplit, counterText = repo.forksCount.toString())
    }
}

@Composable
fun CounterItem(
    icon: ImageVector,
    counterText: String
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = MaterialTheme.colors.onSurface.copy(alpha = OnSurfaceTextAlpha)
    )
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_xsmall)))
    Text(
        text = counterText,
        style = MaterialTheme.typography.caption,
    )
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_small)))
}

@Preview(showBackground = true)
@Composable
fun UsersListItemPreview() {
    ReposListItem(repo = RepoPreview.repo)
}
