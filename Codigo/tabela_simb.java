import java.util.Hashtable;
import java.lang.String;
import java.util.ArrayList;

public class tabela_simb
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
			System.out.println(tipoIdent1 + identificador.image);
        }
        catch(Exception e)
        {
         
        }

        if(tipoIdent1 != 0){
            System.out.println("A variavel "+identificador.image+ " foi decladarada mais de uma vez.");
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
		bolCom.add(19);
		bolCom.add(20);
    }
	
	    public static String checkExist(Token token)
    {
        if(tabela.get(token.image) != null){
			return " ";
		}else {
			return "Erro: Identificador " + token.image + " nao declarado. Linha: "  + token.beginLine +"\r\n";
		}
    }
	
	

    public static String checkAtrib(Token TokenIni, Token TokenAtt, String as)
    {
        int tipoIdent1 = 0;
        int tipoIdent2;        
        try
        {

            tipoIdent1 = (Integer)tabela.get(TokenIni.image);
        }
        catch(Exception e)
        {
            return "Erro: Identificador " + TokenIni.image + " nao declarado. Linha: "  + TokenIni.beginLine +"\r\n";
        }

        if(TokenAtt.kind == 21)
        {
            try
            {
                tipoIdent2 = (Integer) tabela.get(TokenAtt.image);
            }
            catch(Exception e)
            {
				
                return "Erro: Identificador " + TokenAtt.image + " nao declarado. Linha: " + TokenIni.beginLine +"\r\n";
            }
        }
        else if(TokenAtt.kind == 20 ||  TokenAtt.kind == 18 ||  TokenAtt.kind == 19){
            tipoIdent2 = TokenAtt.kind;
		}
        else{
            tipoIdent2 = 0;
		}
        if(tipoIdent1 == 16)
        {
            if(intComp.contains(tipoIdent2))
                return " ";
            else
                return "Erro ao converter " + TokenAtt.image + " para inteiro. Linha: " + TokenIni.beginLine+"\r\n";
        }else if (tipoIdent1 == 18){

            if(intComp.contains(tipoIdent2))
                return " ";
            else
                return "Erro ao converter " + TokenAtt.image + " para inteiro. Linha: " + TokenIni.beginLine+"\r\n";
        }else if(tipoIdent1 == 17){
            if(bolCom.contains(tipoIdent2))
                return " ";
            else
                return "Erro ao converter " + TokenAtt.image + " para booleano. Linha: " + TokenIni.beginLine+"\r\n";
        }
        else
        {
            return "Erro: Identificador " + TokenIni.image + " nao declarado." + "Linha: " + TokenIni.beginLine+"\r\n";
        }
    }
}






