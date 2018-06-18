/* XSE Grammar */
package lucbui.pkmnscripter.flex;

import lucbui.pkmnscripter.language.LexToken;
import lucbui.pkmnscripter.language.LexType;

%%

%class XseLexer
%unicode
%line
%column

%{
    private LexToken symbol(LexType type) {
    return new LexToken(type, yyline, yycolumn);
    }
    private LexToken symbol(LexType type, Object value) {
    return new LexToken(type, yyline, yycolumn, value);
    }
%}

%function nextToken
%type LexToken
%eofval{
    return symbol(LexType.EOF);
%eofval}
%debug

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

Zero = 0
DecimalDigitNotZero = [1-9]
DecimalDigit = {Zero} | {DecimalDigitNotZero}
DecimalNumber = {Zero} | {DecimalDigitNotZero}{DecimalDigit}*
HexDigitNotZero = {DecimalDigitNotZero} | [A-F]
HexDigit = {Zero} | {HexDigitNotZero}
Byte = 0x{HexDigit}{1,2}
Word = 0x{HexDigit}{1,4}
DoubleWord = 0x{HexDigit}{1,8}
MemoryAddress = 0x0{HexDigitNotZero}{HexDigit}{6}

%%

<YYINITIAL> {
    /* preprocessor directives */
    "alias"         { return symbol(LexType.ALIAS); }
    "autobank"      { return symbol(LexType.AUTOBANK); }
    "braille"       { return symbol(LexType.BRAILLE); }
    "break"         { return symbol(LexType.BREAK); }
    "clean"         { return symbol(LexType.CLEAN); }
    "define"        { return symbol(LexType.DEFINE); }
    "const"         { return symbol(LexType.DEFINE); }
    "definelist"    { return symbol(LexType.DEFINELIST); }
    "constlist"     { return symbol(LexType.DEFINELIST); }
    "dynamic"       { return symbol(LexType.DYNAMIC); }
    "erase"         { return symbol(LexType.ERASE); }
    "eraserange"    { return symbol(LexType.ERASERANGE); }
    "freespace"     { return symbol(LexType.FREESPACE); }
    "include"       { return symbol(LexType.INCLUDE); }
    "org"           { return symbol(LexType.ORG); }
    "seek"          { return symbol(LexType.ORG); }
    "raw"           { return symbol(LexType.RAW); }
    "binary"        { return symbol(LexType.RAW); }
    "put"           { return symbol(LexType.RAW); }
    "remove"        { return symbol(LexType.REMOVE); }
    "removeall"     { return symbol(LexType.REMOVEALL); }
    "removemart"    { return symbol(LexType.REMOVEMART); }
    "removemove"    { return symbol(LexType.REMOVEMOVE); }
    "reserve"       { return symbol(LexType.RESERVE); }
    "unalias"       { return symbol(LexType.UNALIAS); }
    "unaliasall"    { return symbol(LexType.UNALIASALL); }
    "undefine"      { return symbol(LexType.UNDEFINE); }
    "deconst"       { return symbol(LexType.UNDEFINE); }
    /* raw bytes */
    {Byte}          { return symbol(LexType.BYTE, yytext()); }
    {Word}          { return symbol(LexType.WORD, yytext()); }
    {DoubleWord}    { return symbol(LexType.DOUBLEWORD, yytext()); }
    {MemoryAddress} { return symbol(LexType.MEMORYADDRESS, yytext()); }
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                    yytext()+">"); }