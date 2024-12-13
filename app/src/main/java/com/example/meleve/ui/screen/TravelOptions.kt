package com.example.meleve.ui.screen

import MeLeveEstimate
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meleve.data.model.mock.mockOptions
import com.example.meleve.ui.components.button.MeLeveButton
import com.example.meleve.ui.components.map.MeLeveMap
import com.example.meleve.ui.components.option.MeLeveOptionsCard
import com.example.meleve.ui.components.option.MeLeveOptionsCardList
import com.example.meleve.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelOptions(
    modifier: Modifier = Modifier,
    estimate: MeLeveEstimate? = null,
    onNavigateBack: () -> Unit = {}
) {
    val bottomSheetState = rememberBottomSheetScaffoldState()
    val isBottomSheetVisible by remember { mutableStateOf(true) }

    val configuration = LocalConfiguration.current

    Column {
        if(isBottomSheetVisible) {
            BottomSheetScaffold(
                scaffoldState = bottomSheetState,
                sheetContainerColor = Gray100,
                sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
                sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                sheetContent = {
                    estimate?.options?.let {
                        MeLeveOptionsCardList(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            options = estimate.options,
                            onOptionCLick = {
                                // Chamada a api de escolha
                            }
                        )
                    }
                },
                content = {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(it)) {

                        if (estimate != null) {
                            MeLeveMap(modifier = Modifier.fillMaxSize(), routeResponse = estimate.routeResponse)
                        }
                        MeLeveButton(
                            iconRes = Icons.Default.ArrowBack,
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(20.dp),
                            onClick = { onNavigateBack() }
                        )
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TravelOptionsPreview() {
    TravelOptions(estimate = null)
}