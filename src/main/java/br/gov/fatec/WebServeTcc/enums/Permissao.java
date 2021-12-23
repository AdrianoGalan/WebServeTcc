package br.gov.fatec.WebServeTcc.enums;

public enum Permissao {

    USUARIO(1, "ROLE_USUARIO"),
    MANUTENTOR(2,"ROLE_MANUTENTOR"),
    ADMIN(3, "ROLE_ADMIN");
    
    private int cod;
    private String descricao;
    
    private Permissao(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
public static Permissao toEnum(Integer cod) throws Exception{

    if(cod == null){
        return null;
    }

    for(Permissao x : Permissao.values()){
        if(cod.equals(x.getCod())){
            return x;
        }
    }

    throw new Exception("cod invalido");
    
}

}
