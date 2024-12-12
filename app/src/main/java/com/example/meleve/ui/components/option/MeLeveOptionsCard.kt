package com.example.meleve.ui.components.option

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meleve.R
import com.example.meleve.data.model.MeLeveOptions
import com.example.meleve.data.model.MeLeveReview
import com.example.meleve.ui.components.button.MeLeveButton
import com.example.meleve.ui.components.rating.MeLeveRating
import com.example.meleve.ui.theme.Gray100
import com.example.meleve.ui.theme.Typography
import java.text.NumberFormat

@Composable
fun MeLeveOptionsCard(
    modifier: Modifier = Modifier,
    options: MeLeveOptions,
    onCLick: (MeLeveOptions) -> Unit = {}
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(width = 1.dp, color = Gray100, shape = RoundedCornerShape(12.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // VEHICLE IMAGE
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth(0.3f)
                    .height(IntrinsicSize.Min)
                    .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.car_white_icon),
                contentDescription = "MeLeve vehicle"
            )

            // MOTORIST INFOR
            Column(

            ) {
                Text(text = options.name, style = Typography.headlineSmall.copy(fontSize = 14.sp))

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    options.description,
                    style = Typography.bodyLarge.copy(fontSize = 12.sp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        "Veículo:",
                        style = Typography.bodyLarge.copy(fontSize = 12.sp, fontWeight = FontWeight.Bold),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2
                    )
                    Text(
                        options.vehicle,
                        style = Typography.bodyLarge.copy(fontSize = 12.sp),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    MeLeveRating(rating = options.review.rating, modifier = Modifier.height(14.dp))

                    VerticalDivider(modifier = Modifier.height(16.dp))

                    Text(
                        text = NumberFormat.getCurrencyInstance().format(options.value),
                        style = Typography.bodyLarge.copy(fontSize = 12.sp)
                    )
                }

                MeLeveButton(
                    text = "escolher",
                    size = "sm",
                    modifier = modifier.align(Alignment.End),
                    onClick = { onCLick(options) }
                )
            }
        }
    }

}

@Preview()
@Composable
private fun MeLeveMotoristCardPreview() {
    MeLeveOptionsCard(
        options = MeLeveOptions(
            id = 1,
            name ="Gustavo santiago",
            description = "Olá! Sou o Homer, seu motorista camarada! Relaxe e aproveite o passeio, com direito a rosquinhas e boas risadas (e talvez alguns desvios).",
            vehicle = "Cruze de cor branca",
            review = MeLeveReview(
                rating = 3,
                comment = "Gustavo sempre é bem solicito"
            ),
            value = 45.5
        )
    )
}