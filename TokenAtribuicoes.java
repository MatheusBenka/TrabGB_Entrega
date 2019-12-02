import java.util.Hashtable;
import java.lang.String;
import java.util.ArrayList;

public class TokenAtribuicoes
{

    private static Hashtable tabela = new Hashtable();

    private static ArrayList<Integer> intComp = new ArrayList();
    private static ArrayList<Integer> bolCom = new ArrayList();

    public static void InserirSimbolo(Token identificador, int tipo)
    {
        int tipoIdent1 = 0;
        try
        {
            tipoIdent1 = (Integer)tabela.get(identificador.image);
        }
        catch(Exception e)
        {
         
        }

        if(tipoIdent1 != 0){
            System.out.println("Variavel "+identificador.image+ " ja foi setada");
        }else
        {
            tabela.put(identificador.image, tipo);
        }

    }

    public static void SetTables()
    {
        intComp.add(16);
        intComp.add(18);
        bolCom.add(17);        
    }

    public static String checkAtrib(Token TokenIni, Token TokenAtt)
    {
        int tipoIdent1 = 0;
        int tipoIdent2;        
        
        try
        {
            tipoIdent1 = (Integer)tabela.get(TokenIni.image);
            System.out.println("tipoIdent1 ->" + tipoIdent1);
        }
        catch(Exception e)
        {
            return "Error: Identificador " + TokenIni.image + " Não foi declarado \r\nLinha: "  + TokenIni.beginLine +"\r\n por regra 1";
        }

        if(TokenAtt.kind == 20) // identificador
        {
            try
            {
                tipoIdent2 = (Integer) tabela.get(TokenAtt.image); // pega da tabela
            }
            catch(Exception e)
            {
                return "Error: Identificador " + TokenAtt.image + " Não foi declarado \r\nLinha: " + TokenIni.beginLine +"\r\n por regra 2 ";
            }
        }
        else if(TokenAtt.kind == 19 ||  TokenAtt.kind == 18)
            tipoIdent2 = TokenAtt.kind;
        else
            tipoIdent2 = 0;

        if(tipoIdent1 == 16)
        {
            if(intComp.contains(tipoIdent2))
                return " ";
            else
                return "Error:Não se pode converter " + TokenAtt.image + " para inteiro \r\nLinha: " + TokenIni.beginLine+"\r\n por regra 3";
        }else if (tipoIdent1 == 18){

            if(intComp.contains(tipoIdent2))
                return " ";
            else
                return "Error:Não se pode converter " + TokenAtt.image + " para inteiro \r\nLinha: " + TokenIni.beginLine+"\r\n por regra 4";
        }else if(tipoIdent1 == 17){

            if(bolCom.contains(tipoIdent2))
                return " ";
            else
                return "Error:Não se pode converter " + TokenAtt.image + " para boolean \r\nLinha: " + TokenIni.beginLine+"\r\n por regra 5";
        }
        else
        {
            return "Identificador " + TokenIni.image + " não foi declarado" + "Linha: " + TokenIni.beginLine+"\r\n por regra 6";
        }
    }

    public static boolean CheckVar(Token token){
           boolean declarado = false;
           try
            {
                int ident = 0;
                ident = (Integer) tabela.get(token.image);
                if(ident != 0){
                    declarado =  true;
                }
            }
            catch(Exception e)
            {
                 System.out.println("Error: Identificador " + token.image + " Não foi declarado \r\nLinha: " + token.beginLine +"\r\n por regra 2 ");                
                 declarado = false;
            }

            return declarado;
    }    
}
