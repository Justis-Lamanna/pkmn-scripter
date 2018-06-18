package lucbui.pkmnscripter.language;

/**
 * The type the token is
 */
public enum LexType {
    COMMAND,
    BYTE,
    WORD,
    DOUBLEWORD,
    MEMORYADDRESS,
    EOF,
    //Preprocessor Directives
    ALIAS,
    AUTOBANK,
    BRAILLE,
    BREAK,
    CLEAN,
    DEFINE,
    DEFINELIST,
    DYNAMIC,
    ERASE,
    ERASERANGE,
    FREESPACE,
    INCLUDE,
    ORG,
    RAW,
    REMOVE,
    REMOVEALL,
    REMOVEMART,
    REMOVEMOVE,
    RESERVE,
    UNALIAS,
    UNALIASALL,
    UNDEFINE,
    UNDEFINEALL
}
