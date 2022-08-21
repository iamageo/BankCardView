<h1 align="center">Visualização de cartão bancário</h1><br/>
<p align="center">
💳 Bank Card View é uma visualização de cartão simples e elegante com animação Flip.
</p>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <img alt="repo size" src="https://img.shields.io/github/repo-size/iamageo/bank-card-view"/>
  <br/>
    <img alt="forks" src="https://img.shields.io/github/forks/iamageo/bank-card-view?style=social"/>
    <img alt="stars" src="https://img.shields.io/github/stars/iamageo/bank-card-view?style=social"/>
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/26925002/182700648-48c7cd1c-6a79-41a4-bc6f-7971017d5709.png" alt="animated" width="50%" />
</p>

## Versões
Selecione a língua : [English](https://github.com/iamageo/bank-card-view/blob/master/README.eng.md), [Português](https://github.com/iamageo/bank-card-view/blob/master/README.md)

## Incluindo em seu projeto
[![](https://jitpack.io/v/iamageo/bank-card-view.svg)](https://jitpack.io/#iamageo/bank-card-view)
### Grade
Adicione os códigos abaixo ao seu arquivo **root** `build.gradle` (não ao seu arquivo build.gradle do módulo).
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
E adicione um código de dependência ao arquivo `build.gradle` do seu **módulo**.
```gradle
dependencies {
    implementation 'com.github.iamageo:bank-card-view:1.0.0'
}
```

## Uso básico
Adicione em seu arquivo de layout.

<img src="https://user-images.githubusercontent.com/26925002/182672634-81a2a84b-c8ee-41d1-851f-4d129278af38.png" align="right"/>

```xml

<com.iamageo.bank_card_view_android.BankCardView
    android:id="@+id/myBankCardView"
    app:isFrontCard="true"
    app:bankCardName="Geovani Amaral"
    app:bankCardNumber="0001 0002 0003 0004"
    app:bankCardCVV="123"
    app:bankCardValidate="02/27"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
/>

```
Chame sua atividade:
```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val animation: FlipBankCardViewAnimation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //attributes
        binding.myBankCardView.bankCardName = "Jhon Doe"
        binding.myBankCardView.bankCardNumber = "0001 0002 0003 0004"
        binding.myBankCardView.bankCardValidate = "02/27"
        binding.myBankCardView.bankCardCVV = "007"
        binding.myBankCardView.bankCardLogo = BankCardView.CardLogo.MASTERCARD
        binding.myBankCardView.bankCardBackground = BankCardView.CardBackground.RIPE_MALINKA

        //click event
        binding.myBankCardView.setOnClickListener {
            startAnimation(animation, binding.myBankCardView, binding.myBankCardView, 180)
        }
    }
}
```

## Exemplo de uso
![20220803_162927](https://user-images.githubusercontent.com/26925002/182701061-2824d4cc-1049-435f-a8f0-98843e8d0a93.gif)


## Atributos de visualização de cartão bancário
Atributos | Tipo | Descrição
--- | --- | ---
bankCardName | String | Nome do cartão.
bankCardNumber | String | Número do cartão.
bankCardValidate | String | Data de validade do cartão.
bankCardCVV | String | Código de segurança do cartão.
bankCardLogo | Int (drawable) | Logo do cartão.
bankCardBackground | Int (drawable) | Plano de fundo para exibição.

## Tipos de logotipo
[Fonte dos logotipos](https://vetores.org/)

| VISTO | CIELO | MASTERCARD | EXPRESSO AMERICANO
| :---------------: | :---------------: | :---------------: | :---------------: |
| <img src="https://vetores.org/wp-content/uploads/visa.png" align="center" width="50%"/> | <img src="https://vetores.org/wp-content/uploads/cielo.png" align="center" width="50%"/> | <img src="https://vetores.org/wp-content/uploads/mastercard.png" align="center" width="50%"/> | <img src="https://vetores.org/wp-content/uploads/american-express.png" align="center" width="50%"/>

Para usar o logotipo do cartão:

```kotlin
binding.myBankCardView.bankCardLogo = BankCardView.CardLogo.MASTERCARD
```

## Tipos de fundo
[Fonte dos fundos](https://webgradients.com/)

| RIPE_MALINKA |AMY_CHRISP | TRUE_SUNSET | PURPLE_DIVISION
| :---------------: | :---------------: | :---------------: | :---------------: |
| <img src="https://webgradients.com/public/webgradients_png/017%20Ripe%20Malinka.png" align="center" width="50%"/> | <img src="https://webgradients.com/public/webgradients_png/014%20Amy%20Crisp.png" align="center" width="50%"/> | <img src="https://webgradients.com/public/webgradients_png/021%20True%20Sunset.png" align="center" width="50%"/> | <img src="https://webgradients.com/public/webgradients_png/069%20Purple%20Division.png" align="center" width="50%"/> |

Para usar os planos de fundo:

```kotlin
binding.myBankCardView.bankCardBackground = BankCardView.CardBackground.RIPE_MALINKA
```

## Licença

```
    Copyright 2022 Geovani Amaral

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```
