package com.example.financemanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView balanceTextView;
    private EditText incomeEditText;
    private EditText expenseEditText;

    private double balance = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        balanceTextView = findViewById(R.id.balanceTextView);
        incomeEditText = findViewById(R.id.incomeEditText);
        expenseEditText = findViewById(R.id.expenseEditText);

        Button addIncomeButton = findViewById(R.id.addIncomeButton);
        Button addExpenseButton = findViewById(R.id.addExpenseButton);

        addIncomeButton.setOnClickListener(v -> addIncome());

        addExpenseButton.setOnClickListener(v -> addExpense());
    }

    private void addIncome() {
        String incomeString = incomeEditText.getText().toString();
        if (!incomeString.isEmpty()) {
            double income = Double.parseDouble(incomeString);
            balance += income;
            updateBalance();
            incomeEditText.setText("");
        }
    }

    private void addExpense() {
        String expenseString = expenseEditText.getText().toString();
        if (!expenseString.isEmpty()) {
            double expense = Double.parseDouble(expenseString);
            balance -= expense;
            updateBalance();
            expenseEditText.setText("");
        }
    }

    private void updateBalance() {
        balanceTextView.setText(String.format("Баланс: %s", balance));
    }
}
