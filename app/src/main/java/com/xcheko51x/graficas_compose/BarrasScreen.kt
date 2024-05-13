package com.xcheko51x.graficas_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer

@Composable
fun BarrasScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Gráfica de Barras"
        )

        Barras()
    }
}

@Composable
fun Barras() {
    val datos = DatosGraficar.datos

    var barras = ArrayList<BarChartData.Bar>()

    datos.mapIndexed { index, datos ->
        barras.add(
            BarChartData.Bar(
                label = datos.label,
                value = datos.value,
                color = Utils().colorAleatorio()
            )
        )
    }

    BarChart(
        modifier = Modifier
            .padding(30.dp, 80.dp)
            .height(300.dp),
        labelDrawer = SimpleValueDrawer(
            drawLocation = SimpleValueDrawer.DrawLocation.XAxis
        ),
        barChartData = BarChartData(
            bars = barras
        )
    )
}