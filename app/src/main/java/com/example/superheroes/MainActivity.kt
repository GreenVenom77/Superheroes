package com.example.superheroes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.data.Datasource
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroesApp()
                }
            }
        }
    }
}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .sizeIn(minHeight = dimensionResource(R.dimen.image_size))
            .padding(
                top = dimensionResource(R.dimen.small_padding),
                bottom = dimensionResource(R.dimen.small_padding),
                start = dimensionResource(R.dimen.medium_padding),
                end = dimensionResource(R.dimen.medium_padding)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.medium_padding))
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(hero.nameResourceId),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descResourceId),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = modifier.width(dimensionResource(R.dimen.medium_padding)))
            Box(
                modifier = modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .clip(MaterialTheme.shapes.small)
            ) {
                Image(
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(hero.imageResourceId),
                    contentDescription = stringResource(hero.nameResourceId),
                )
            }
        }
    }
}

@Composable
fun HeroesApp(modifier: Modifier = Modifier) {

}

@Preview(showSystemUi = true)
@Composable
fun CardPreview() {
    SuperheroesTheme {
        HeroCard(Datasource().LoadHeroes()[0])
    }
}

@Preview("Light Theme", showSystemUi = true)
@Preview("Dark Theme", showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppPreview() {
    SuperheroesTheme {
        HeroesApp()
    }
}