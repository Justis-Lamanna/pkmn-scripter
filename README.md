# pkmn-scripter
Gen III Pokemon Script Editor for fun

Intention is to create a more customizable script editor, that can be used across multiple platforms.
In addition to raw byte-to-script translations, the user can use a coding language more similar to real languages
for ease of use.

## How To Use
1. Open Intellij. Click Check out from Version Control dropdown
2. Copy the clone url from this repo (https://github.com/Justis-Lamanna/pkmn-scripter.git)
3. It will ask if you want to create an IntelliJ IDEA project for the sources you have checked out. Hit Yes
4. Import project from external model > Maven > Next
5. Check "Search for projects recursively. Leave everything else as default. Hit Next
6. Make sure two projects are checked. Hit Next
7. Select your JDK. If it's not there, hit the + and import it. Hit Next
8. Give the project a name and location, or leave it as default. Hit Finish
9. You will have two projects, "lexer" and "scripter". Lexer has code related to the lexer generation, while Scripter is the actual GUI.

## Building the Lexer
1. Download JFlex here: http://jflex.de/download.html. Save it somewhere safe, where you'll remember it.
2. View > Tool Windows > Ant Build. Click "Properties", or hit Alt+Enter
3. Select "Additional Classpath", then "Add". Navigate to [where you saved JFlex]/lib. Select both jar files inside. Hit OK
4. Drago "pkmn_scripter.xml" from the Lexer project into the Ant Build window. Five scripts should appear.
5. Double-click on "flex". This should run for a few seconds, and spit out "XseLexer.java" into lexer/src/main/java/lucbui/pkmnscripter/flex
6. Ctrl+Shift+F9 to rebuild the lexer project, so everything compiles properly.