# Jabberpoint


## Aanpassingen
Ik heb niet gebruikte fields verweiderd in meerdere klassen, het zelfde geld voor niet gebruikte functies.
Ik heb een StyleFactory class gemaakt zodat de class Style zichtzelf niet aanmaakt, de class JabberPoint roept nu de StyleFactory aan om de styles te maken.

Ik heb de keyevents in KeyController aangepast zodat er niet naar '+' en '-' gezocht wordt maar naar KV_PLUS en KV_CTR en KV_MINUS. Ook heb ik de switch case in KeyController opgeschoond zodat de cases die het zelfde doenet commas achter elkaar staan.

Ik heb MenuController opgesplitst in MenuController, MyMenu en MenuFactory zodat MenuController niet meer het menu aan maakt, dat gebeurt nu in MenuFactory doormiddel van een fileMenu, viewMenu en helpMenu functie. De functionaliteiten van het menu staan in MyMenu als verschillende functies. MenuFactory roept deze dan aan voor het maken van het menu.

Ik de saveFile functie in XMLAccessor opgedeeld in saveFileHeader in de class XMLAccessor zelf en heb de functie printXML toegevoegd aan SlideItem, vervolgens heb ik de functie printXML in BitmapItem en TextItem de verschillende xml stukken laten uitprinten. Deze functie word dan weer aangeroepen in saveFile via SlideItem zodat er niet meer gecheckt hoeft te worden waar SlideItem een instance van is.

Ik heb er voor gezondst het niet meer mogelijk is om naar een slide te gaan die er niet is door wat aan te passen aan de if statements in Presentation. Hierdoor ondervond ik wel het probleem dat open file en new file het niet meer deden, waardoor ik uiteindelijk in een of statement heb gezet dat als het ingevoerde slide nummer lager is dan -1 hij terug gaat naar 1. Vervolgens gaat hij als je een slide lager dan 0 invoert naar slide 2 van de zoveel, ik weet niet hoe ik dit moet oplossen maar het is op het moment beter dan dat de new en open file functie een error geven waarbij de applicatie vast liep soms. 


## Wat ik er nog aan zo willen veranderen:

Ik denk dat er nog een aantal functies in zitten die te lang zijn, zoals de loadFile functie van XMLAccessor. 

Ik begrijp niet helemaal waarom wanneer er op new file gedrukt wordt er een lege dia wordt getoont, persoonlijk denk ik dat je dan de keuzen moet krijgen om er wat in te zetten maar dat zou een hele nieuwe functionaliteit zijn.

Bij open file opent hij alleen maar een test presentatie, persoonlijk denk ik dat je hier de kans moet krijgen om uit bestanden te kiezen.



## Class diagrams
First Jabberpoint:
![First jaberpoint](/ClassDiagramms/FirstJabber.png)

Refacored Jabberpoint
![Refactored jabberpoint](/ClassDiagramms/RefactoredJabber.png)


## Use case diagram
![UseCase](/ClassDiagramms/UseCaseDiagram.png)


## Activity flow diagrams

Switch slide: 

![Switch slide](/ClassDiagramms/SwitchSlideFlow.png)


Exit jabberpoint:

![Exit](/ClassDiagramms/ExitFlow.png)
