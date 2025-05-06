package com.vipermech.mindtrack.presentation.ui.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vipermech.mindtrack.presentation.ui.measures.cardHeightLarge
import com.vipermech.mindtrack.presentation.ui.measures.cardHeightMedium
import com.vipermech.mindtrack.presentation.ui.measures.cardHeightSmall
import com.vipermech.mindtrack.presentation.ui.measures.elevateLevelDefault
import com.vipermech.mindtrack.presentation.ui.measures.paddingDefault

@Composable
fun CardLarge(content: @Composable ColumnScope.() -> Unit){

    Card(
        modifier = Modifier.fillMaxWidth().height(cardHeightLarge).padding(paddingDefault),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = elevateLevelDefault),
        content = content
    )

}

@Composable
fun CardMedium(content: @Composable ColumnScope.() -> Unit){

    Card(
        modifier = Modifier.fillMaxWidth().height(cardHeightMedium).padding(paddingDefault),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = elevateLevelDefault),
        content = content
    )

}

@Composable
fun CardSmall(content: @Composable ColumnScope.() -> Unit){

    Card(
        modifier = Modifier.fillMaxWidth().height(cardHeightSmall).padding(paddingDefault),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = elevateLevelDefault),
        content = content
    )

}