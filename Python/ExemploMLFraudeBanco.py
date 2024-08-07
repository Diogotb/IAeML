import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import classification_report, accuracy_score

# Carregar dados (substitua 'fraud_data.csv' pelo caminho do seu arquivo de dados)
data = pd.read_csv('src/fraud_data.csv')

# Selecionar características e rótulos
X = data.drop('is_fraud', axis=1)  # Características
y = data['is_fraud']  # Rótulo

# Dividir dados em treinamento e teste
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Treinar modelo de floresta aleatória
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.fit(X_train, y_train)

# Fazer previsões no conjunto de teste
y_pred = model.predict(X_test)

# Avaliar modelo
print('Accuracy:', accuracy_score(y_test, y_pred))
print('Classification Report:')
print(classification_report(y_test, y_pred))
