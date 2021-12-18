package com.example.mvvm_callapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm_callapp.model.Person
import com.example.mvvm_callapp.viewmodel.PersonViewModel

@Composable
fun ListItemView(person: Person, personViewModel: PersonViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            Modifier
                .fillMaxWidth(0.8F)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "${person.firstName} ${person.lastName}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Call,
                    contentDescription = "call icon",
                    tint = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = person.phoneNumber, style = TextStyle(fontWeight = FontWeight.Bold))
            }
        }

        Icon(
            modifier = Modifier.clickable { personViewModel.deletePerson(person) }.padding(16.dp),
            imageVector = Icons.Default.Delete,
            tint = MaterialTheme.colors.secondary,
            contentDescription = "delete icon"
        )

    }
}


@Composable
@Preview(showBackground = true)
fun ItemPreview() {
    ListItemView(
        person = Person(
            firstName = "Egemen",
            lastName = "Tokgöz",
            phoneNumber = "44554455"
        ), viewModel()
    )
}