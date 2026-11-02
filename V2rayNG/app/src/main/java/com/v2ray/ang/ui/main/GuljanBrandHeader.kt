package com.v2ray.ang.ui.main

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val GuljanNavy = Color(0xFF020713)
private val GuljanBlue = Color(0xFF00BFFF)
private val GuljanCyan = Color(0xFF00F0FF)

@Composable
fun GuljanBrandHeader(
    isRunning: Boolean,
    onConnect: () -> Unit,
) {
    val cardShape = RoundedCornerShape(26.dp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clip(cardShape)
            .background(GuljanNavy)
            .border(1.dp, Color(0xFF075BBD), cardShape)
            .padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "GULJAN",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 1.4.sp
                )
                Text(
                    text = "ULTRA VPN",
                    color = GuljanCyan,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.8.sp
                )
            }
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Brush.radialGradient(listOf(Color(0xFF123F87), GuljanNavy)))
                    .border(2.dp, GuljanBlue, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("🔒", fontSize = 27.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("♛", color = Color(0xFFFFD740), fontSize = 27.sp)
                Text("FREE", color = Color(0xFFFFD740), fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(194.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(Modifier.fillMaxSize()) {
                val step = 13.dp.toPx()
                for (x in 0..(size.width / step).toInt()) {
                    for (y in 0..(size.height / step).toInt()) {
                        val px = x * step
                        val py = y * step
                        val nx = px / size.width
                        val ny = py / size.height
                        val continentLike = (nx in 0.08f..0.36f && ny in 0.22f..0.76f) ||
                            (nx in 0.43f..0.72f && ny in 0.18f..0.58f) ||
                            (nx in 0.73f..0.92f && ny in 0.38f..0.72f)
                        if (continentLike && (x + y) % 2 == 0) {
                            drawCircle(
                                color = GuljanBlue.copy(alpha = 0.30f),
                                radius = 1.5.dp.toPx(),
                                center = androidx.compose.ui.geometry.Offset(px, py)
                            )
                        }
                    }
                }
                val center = androidx.compose.ui.geometry.Offset(size.width / 2f, size.height / 2f)
                drawCircle(GuljanBlue.copy(alpha = 0.55f), radius = 88.dp.toPx(), center = center, style = Stroke(2.dp.toPx()))
                drawCircle(GuljanCyan.copy(alpha = 0.35f), radius = 100.dp.toPx(), center = center, style = Stroke(1.dp.toPx()))
            }
            Box(
                modifier = Modifier
                    .size(154.dp)
                    .shadow(18.dp, CircleShape)
                    .clip(CircleShape)
                    .background(Brush.radialGradient(listOf(Color(0xFF123D80), Color(0xFF030A18), Color.Black)))
                    .border(4.dp, GuljanCyan, CircleShape)
                    .clickable(role = Role.Button, onClick = onConnect),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(if (isRunning) "⏻" else "⏻", color = GuljanCyan, fontSize = 54.sp, fontWeight = FontWeight.Light)
                    Text(if (isRunning) "Disconnect" else "Connect", color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFF030D1D))
                .border(1.5.dp, GuljanBlue, RoundedCornerShape(30.dp))
                .padding(horizontal = 18.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(if (isRunning) Color(0xFF20E66B) else Color(0xFFFFB52E))
            )
            Text(
                text = if (isRunning) "  CONNECTED  •  VPN ACTIVE" else "  DISCONNECTED  •  TAP TO CONNECT",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("SERVER LIST", color = Color(0xFF9FCBFF), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Text("Choose a server below", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
            Text("↓", color = GuljanCyan, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MiniStat("DOWNLOAD", "Live in app")
            MiniStat("UPLOAD", "Live in app")
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Developed by: Gul Jan Saeedi",
            color = GuljanCyan,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp
        )
    }
}

@Composable
private fun MiniStat(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(label, color = Color(0xFF80B8F5), fontSize = 9.sp, fontWeight = FontWeight.Bold)
        Text(value, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    }
}
