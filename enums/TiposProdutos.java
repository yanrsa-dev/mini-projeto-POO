package enums;

public enum TiposProdutos {
  ALIMENTOS_PERECIVEIS(true),
  BEBIDAS_REFRIGERADAS(true),
  LATICINIOS(true),
  CARNES(true),
  FRUTAS_E_VERDURAS(true),

  ELETRONICOS(false),
  ALIMENTOS_NAO_PERECIVEIS(false),
  BEBIDAS(false),
  PRODUTOS_DE_LIMPEZA(false),
  HIGIENE_PESSOAL(false),
  PAPELARIA(false),
  UTILIDADES_DOMESTICAS(false);

  private final boolean perecivel;

  TiposProdutos(boolean perecivel) {
    this.perecivel = perecivel;
  }

  public boolean perecivel() {
    return perecivel;
  }
}
