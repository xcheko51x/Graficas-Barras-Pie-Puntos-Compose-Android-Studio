package com.xcheko51x.graficas_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer

@Composable
fun PastelScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Gráfica de Pastel"
        )

        Pastel()
    }
}

@Composable
fun Pastel() {
    val datos = DatosGraficar.datos

    var slices = ArrayList<PieChartData.Slice>()

    datos.mapIndexed { index, datos ->
        slices.add(
            PieChartData.Slice(
                value = datos.value,
                color = Utils().colorAleatorio()
            )
        )
    }

    PieChart(
        modifier = Modifier
            .padding(30.dp, 80.dp)
            .height(300.dp),
        sliceDrawer = SimpleSliceDrawer(
            sliceThickness = 100f
        ),
        pieChartData = PieChartData(
            slices = slices
        )
    )
}