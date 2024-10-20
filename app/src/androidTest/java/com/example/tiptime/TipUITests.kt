import java.text.NumberFormat

@Test
fun calculate_20_percent_tip() {
    composeTestRule.setContent {
        TipTimeTheme {
            Surface (modifier = Modifier.fillMaxSize()){
                TipTimeLayout()
            }
        }
    }
    composeTestRule.onNodeWithText("Bill Amount")
        .performTextInput("10")
    composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
    val expectedTip = NumberFormat.getCurrencyInstance().format(2)
    composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
        "No node with this text was found."
    )
}