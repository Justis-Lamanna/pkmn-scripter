/* JFlex example: partial Java language lexer specification */
import lucbui.pkmnscripter.language.*;

/**
    * This class is a simple example lexer.
    */
%%

%class XseLexer
%unicode
%line
%column

%{
    StringBuffer string = new StringBuffer();

    private LexToken symbol(LexType type) {
    return new LexToken(type, yyline, yycolumn);
    }
    private LexToken symbol(LexType type, Object value) {
    return new LexToken(type, yyline, yycolumn, value);
    }
%}

%function nextToken
%type LexToken
%eof{
    return symbol(LexType.EOF);
%eof}
%debug

%%

/* keywords */
<YYINITIAL> "abstract"           { return symbol(LexType.COMMAND); }

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                    yytext()+">"); }