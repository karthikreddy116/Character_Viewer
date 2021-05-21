# Character_Viewer
App Requirements
Write a sample app that fetches and displays data from a RESTful Web API. The app should be comprised of two parts, a list and a detail. On
Phones, the list and detail should be separate screens, on Tablets, list and detail should appear on the same screen. Your app should be written
either in Swift for iOS, or Kotlin for Android.
For the list view, data should be displayed as a text only, vertically scrollable list of character names
The app should offer search functionality that filters the character list according to characters whose titles or descriptions contain the
query text
Clicking on an item should load the detail view of that character, including the character’s image, title, and description. You choose the
layout of the detail.
For the image in the detail view, use the URL in the "Icon" field of the API JSON response. For items with blank or missing image URLs,
use a placeholder image of your choice.
Two variants of the app should be created, using a single shared codebase. Each variant should have a different name, package-name, and url
that it pulls data from. (We're interested in your methodology for creating multiple apps from a shared codebase)
Version One
Name: Simpsons Character Viewer
Data API: http://api.duckduckgo.com/?q=simpsons+characters&format=json
Package/Bundle name: com.sample.simpsonsviewer

Version Two
Name: The Wire Character Viewer
Data API: http://api.duckduckgo.com/?q=the+wire+characters&format=json
Package/Bundle name: com.sample.wireviewer
Using Libraries To Complete The Task
Use open source libraries as you see fit, but we must be able to build and run your project in the IDE. Before sending, consider building and
running your project from a clean environment.
Reaching Out For More Information
Please reach out with any questions you have, or if any part of the above is unclear or ambiguous.
Note
This code is purely an exercise to assess your software engineering skill level. We will never use any of your code in any of our
products, and you retain full ownership of anything you submit.
