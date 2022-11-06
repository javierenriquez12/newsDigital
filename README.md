<p align="center">
    <img src="images/news_digital.gif" />
</p>

<p align="center">
NewsDigital is a project that contains a list of news and its details where the latest android technologies are included</p>

[![Android](https://badgen.net/badge/documentation/v1.0.1/green)]()

<!-- region:description -->

This project aims to meet the challenge of Apply Digital, in addition to having the implementation of MVVM + Clean Architecture + Dagger hilt + Flow, and android jetpack libraries

<!-- endregion:description -->

## Table of Contents

1. [let's start](#let's start)
2. [Quick Start](#quick-start)
3. [Use and demonstration](#use-and-demonstration)
4. [Compatibility](#compatibility)

<a name="let's start"></a>

## Let us begin

<a name="quick-start"></a>

## Quick start

[//]: # 'region:quick-start'

> No additional configuration required

[//]: # 'endregion:quick-start'

<a name="use-and-demonstration"></a>

## Usage and demo

[//]: # 'region:usage-demo'

[//]: # 'general content diagram'

#### Internal structure

The project included MVVM (Model View ViewModel) architecture pattern was used, coroutines, live data, sealed classes, repository and data sources.

> Navigation should be handled via [**Navigation Component**] (https://developer.android.com/guide/navigation/navigation-getting-started).<br><br>
> In case other activities have to be managed, the stack of views must be taken into account to be able to remove them when the project flow ends.

<p align="center">
    <img src="images/sample_mvvm.png" />
</p>

If the project starts to grow, it is recommended to use a clean architecture as shown below:




<a name="compatibility"></a>

## Compatibilidad

| Min SDK              | Target SDK          | Java     | Kotlin | AGP  |
|----------------------|---------------------|----------|--------|------|
| API 26 (Android 8.0) | API 33 (Android 13) | Java 11+ | 1.9.0  | 7.0+ |