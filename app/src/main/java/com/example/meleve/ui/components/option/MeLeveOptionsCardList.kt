package com.example.meleve.ui.components.option

import MeLeveOption
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.data.model.mock.mockOptions
import com.example.meleve.ui.theme.Typography

@Composable
fun MeLeveOptionsCardList(
    modifier: Modifier = Modifier,
    options: List<MeLeveOption>,
    onOptionCLick: (MeLeveOption) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text("Encontre motoristas próximo a você", style = Typography.bodyLarge)
        }

        items(items = options, key = { it.id }) {
            MeLeveOptionsCard(options = it, onCLick = { onOptionCLick(it) } )

            Spacer(modifier = Modifier.height(8.dp))

            if(options.last() != it) {
                HorizontalDivider(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeLeveOptionsCardListPreview() {
    MeLeveOptionsCardList(modifier = Modifier, options = mockOptions)
}