class Item{
  private String SKU;
  private String name;
  private String category; 
  private int quantity; 
  private int minQuantity; 
  private double vendorPrice; 
  private int markupPercentage;
  private double regularPrice;
  private int discount;
  
  
  private double currentPrice;

  public Item(String[] listOfLines){

    this.SKU=listOfLines[0];
    this.name=listOfLines[1];
    this.category=listOfLines[2];
    this.quantity=Integer.parseInt(listOfLines[3]);
    this.minQuantity=Integer.parseInt(listOfLines[4]);
    this.vendorPrice=Double.parseDouble(listOfLines[5]);
    this.markupPercentage=Integer.parseInt(listOfLines[6]);
    this.regularPrice=Double.parseDouble(listOfLines[7]);
    this.discount=Integer.parseInt(listOfLines[8]);
    this.currentPrice=Double.parseDouble(listOfLines[9]);
  }


  public String getSKU(){
    return this.SKU;
  }

  public String getName(){
    return this.name;
  }
  
  public String getCategory(){
    return this.category;
  }

  public int getQuantity(){
    return this.quantity;
  }

  public int getMinQuantity(){
    return this.minQuantity;
  }
  
  public double getVendorPrice(){
    return this.vendorPrice;
  }
  
  public int getMarkupPercentage(){
    return this.markupPercentage;
  }
    
  public int getDiscount(){
    return this.discount;
  }
  
  public double getCurrentPrice(){
    return this.currentPrice;
  }

  public double getregularPrice(){
    return this.regularPrice;
  }
  
  


  public void setSKU(String SKU){

    this.SKU=SKU;
  }


  public void setName(String name){
    this.name=name;
  }

  public void setCategory(String category){
    this.category=category;
  }


  public void setQuantity(int quantity){
    this.quantity=quantity;
  }



  public void setMinQuantity(int minQuantity){
    this.minQuantity=minQuantity;
  }


  public void setVendorPrice(double vendorPrice){
    this.vendorPrice=vendorPrice;
  }

  public void setMarkupPercentage(int markupPercentage){
    this.markupPercentage=markupPercentage;
  }
  
  public void setRegularPrice(double regularPrice){
    this.regularPrice=regularPrice;
  }


  public void setDiscount(int discount){
    this.discount=discount;
  }

   
  
  public void setCurrentPrice(double currentPrice){
    this.currentPrice=currentPrice;
  }

  
  }


  

  

  
