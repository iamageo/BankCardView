<h1 align="center">Bank Card View</h1><br/>
<p align="center"> 
💳 Bank Card View is a simple and elegant card view with Flip animation.
</p>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <img alt="repo size" src="https://img.shields.io/github/repo-size/iamageo/bank-card-view"/>
  <br/>
    <img alt="forks" src="https://img.shields.io/github/forks/iamageo/bank-card-view?style=social"/>
    <img alt="stars" src="https://img.shields.io/github/stars/iamageo/bank-card-view?style=social"/>
</p>

## Screenshots

## Including in your project
[![](https://jitpack.io/v/iamageo/bank-card-view.svg)](https://jitpack.io/#iamageo/bank-card-view)
### Gradle
Add below codes to your **root** `build.gradle` file (not your module build.gradle file).
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
And add a dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
    implementation 'com.github.iamageo:bank-card-view:1.0.0'
}
```

## Basic Usage
Add in you Activity file.

```xml
<com.iamageo.bank_card_view_android.BankCardView
    android:id="@+id/myBankCardView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    />
```

## License
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