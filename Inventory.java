import java.io.*;

import java.util.*;



import java.time.LocalDateTime;

import java.io.File; 



class Inventory{

    private ArrayList<Item> itemList = new ArrayList<Item>();
  


  public Inventory(String fileName){



    String line;

    
    
    
    try(BufferedReader bufReader = new BufferedReader(new FileReader(fileName))){  
      
      while((line = bufReader.readLine())!= null){
        
        // line = bufReader.readLine();
        String[] lineAsList = line.split(",");


       

        
        

        Item item = new Item(lineAsList);
        itemList.add(item);

       
        

        
        // for (int i = 0; i < lineAsList.length; i++) {
        //   System.out.print(lineAsList[i]+" ");
        // }
        //   System.out.print("\n");        
        // System.out.println(lineAsList.toString());

       }
      while (line != null) {

     

      
      // itemList.add(line);
      line = bufReader.readLine();
    }
      bufReader.close();
      
    }
     catch (FileNotFoundException e) {
        // Exception handling
    } catch (IOException e) {
        // Exception handling
    }
    




  // for(Item item: itemList){
  //   System.out.println(item.getName());
  // }


   
    

     
  }

   public void updateInventoryFile(){
     ArrayList<String> fileContent = new ArrayList<String>();

     String temp;


      try(BufferedReader bufReader = new BufferedReader(new FileReader("inventory.txt"))){  
      
      while(( temp = bufReader.readLine())!= null){


        


        fileContent.add(temp);
        


        
        

     

     
     




        



        }

      }
     catch (FileNotFoundException e) {
        // Exception handling
    } catch (IOException e) {
        // Exception handling
    }

     


     


     
   String time = LocalDateTime.now().toString();
   String newFileName = "inventory "+time+".txt";
   
   File file = new File(newFileName);
       
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFileName, true))) {

      
      for(String line: fileContent){

        bufferedWriter.write(line+"\n");
        
      }
    } catch (IOException e) {
      // Exception handling
    }



     try(PrintWriter writer = new PrintWriter("inventory.txt")){
      writer.print("");



        

         for(Item item: itemList){


        String line = 
          item.getSKU() +","+ 
          item.getName()+","+
          item.getCategory()+","+
          String.valueOf(item.getQuantity())+","+
          String.valueOf(item.getMinQuantity())+","+
          String.valueOf(item.getVendorPrice())+","+
          String.valueOf(item.getMarkupPercentage())+","+
          String.valueOf(item.getregularPrice())+","+
          String.valueOf(item.getDiscount())+","+
          String.valueOf(item.getCurrentPrice());
         

             
          writer.write(line+"\n");


          
        
      }
          
        
      writer.close();


     } catch(FileNotFoundException e){
       
     }

        }


  public void createNewItem(){

    String 
      SKU,name,category,quantity,minQuanitity,markupPercentage,regularPrice,discount, vendorPrice, currentPrice;



    Scanner input = new Scanner(System.in);

    Scanner inputInt = new Scanner(System.in);
   

    

    SKULoop:
    while(true){
       System.out.println("what is the SKU of the new item");

       SKU=input.nextLine();
      
    for(Item item: itemList ){

         String temp=item.getSKU();

      
        
        if (SKU.equals(temp)){

          System.out.println("invalid input SKU already exists");

         continue SKULoop;

                 
        }else{
          break SKULoop;
        }
      } 
    }

    
    NameLoop:
    while(true){
       System.out.println("what is the name of the new item");

        name=input.nextLine();
      
    for(Item item: itemList ){

         String temp=item.getName();

      
        
        if (name.equals(temp)){

          System.out.println("invalid input name already exists");

         continue NameLoop;

                 
        }else{
          break NameLoop;
        }
      } 
    }

    

          System.out.println("what is the category of the new item");
          category=input.nextLine();
          category= category.toUpperCase();




        while (true){
          System.out.println("what is the quantity of the new item");
             quantity = input.nextLine();

            try{

              int quantityAsNum = Integer.parseInt(quantity);
              break;
              
            } catch (NumberFormatException ex){
              System.out.println("invalid input, must be an Integer");

            
            }
        }




    while(true){

      System.out.println("what is the minquantity of your item");

      minQuanitity =input.nextLine();
      try{


        int minQuantityAsNume=Integer.parseInt(minQuanitity);
        break;

        
      } catch (NumberFormatException ex){
              System.out.println("invalid input, must be an Integer");

      
      }

  }


      while(true){

      System.out.println("what is the vendorprice of your item");

       vendorPrice=input.nextLine();
      try{


        Double intvendorPrice=Double.parseDouble(vendorPrice);

        
        break;
        

        
      } catch (NumberFormatException ex){
              System.out.println("invalid input, must be an double");

      
      }

  }




    while(true){

      System.out.println("what is the markupPercentage of your item");

       markupPercentage =input.nextLine();
      try{


        int numMarkupPercentage=Integer.parseInt(markupPercentage);
        break;

        
      } catch (NumberFormatException ex){
              System.out.println("invalid input, must be an Integer");

      
      }

  }




    while(true){

      System.out.println("what is the regularprice of your item");

       regularPrice=input.nextLine();
      try{


        Double regularPriceAsNum=Double.parseDouble(regularPrice);

        
        break;
        

        
      } catch (NumberFormatException ex){
              System.out.println("invalid input, must be an double");

      
      }

  }


    
  


    while(true){

      System.out.println("what is the discount of your item");

       discount =input.nextLine();
      try{


        int numDiscount=Integer.parseInt(discount);
        break;

        
      } catch (NumberFormatException ex){
              System.out.println("invalid input, must be an Integer");

      
      }

      

  }



    while(true){

      System.out.println("what is the current price of your item");

       currentPrice=input.nextLine();
      try{


        Double currentPriceAsNum=Double.parseDouble(currentPrice);

        
        break;
        

        
      } catch (NumberFormatException ex){
              System.out.println("invalid input, must be an double");

      
      }

          
          

  }



          String paramaters[] = {SKU,name,category,quantity,minQuanitity,vendorPrice,markupPercentage,regularPrice,discount, currentPrice};


    System.out.println(paramaters.toString());

         Item newItem = new Item(paramaters);



          itemList.add(newItem);
          updateInventoryFile();


        
          




    



}


public int restock(){

  Scanner input_int = new Scanner(System.in);



  

  
  int quant; 

  
  System.out.println("how much would you like to add ");

  quant=input_int.nextInt();


  return quant;
  
  
  
  
}


  public String name(){
    Scanner input = new Scanner(System.in);



    String name;
    

     System.out.println("what is the name of the item you would like to restock ");

    
   name= input.nextLine();
    
    return name;
    
    
  }


  // public boolean value(){
  //   boolean value; 

  //    Scanner input = new Scanner(System.in);

  //   System.out.println("please enter true all lowercase for adding and false all lowercase for subtracting");

    
  //   value = input.nextBoolean();

  //   System.out.println(value);

  //   return value; 
  // }


  
  

public void updateItemQuantity(String name, int subQaunt, boolean value){


int newQuantity;

  for(Item item: itemList){

    String checkName=item.getName();

    if(checkName.equals(name)){


      int curentQuantity=item.getQuantity();



       if(value){


      newQuantity= curentQuantity+subQaunt;

      item.setQuantity(newQuantity);

      updateInventoryFile();
        
      }




      else {
        
       newQuantity = curentQuantity - subQaunt;

      item.setQuantity(newQuantity);

       updateInventoryFile();
      }


     

      
      
   
    }



    
    



    

    
  }




  

  


  

  




      
  
  
}


 public void inventoryReport(){





   for(Item item: itemList ){



     System.out.println("SKU:"+item.getSKU()+"\n"+"name:"+item.getName()+"\n"+"category:"+item.getCategory()+"\n"+"quantity:"+item.getQuantity()+"\n"+"minQuantity:"+item.getMinQuantity()+"\n"+"vendorPrice:"+item.getVendorPrice()+"\n"+"markupPercentage:"+item.getMarkupPercentage()+"\n"+"regularPrice:"+item.getregularPrice()+"\n"+"discount:"+item.getDiscount()+"\n"+"currentPrice:"+item.getCurrentPrice()+"\n\n\n");

  try{
    
  
  Thread.sleep(1500);
  System.out.print("\033[H\033[2J");  


     }  

     catch(InterruptedException e){
       
     }
     
       
     }




        
        
    
 }

  public void modifyItems(){

    String itemName;

    Scanner input_string = new Scanner(System.in);
    Scanner input_int = new Scanner(System.in);
     Scanner input_double = new Scanner(System.in);
    

    System.out.println("what is the name of the item you would like to modify"); 

    itemName = input_string.nextLine();




    System.out.println("what paramter of the item would you like to modify you cannot modfiy the SKU, name, and quantity "+"\n"+"1 for category"+"\n"+"2 for minquantity"+"\n"+"3 for vendorPrice"+"\n"+"4 for markupPercentage"+"\n"+"5 for regularPrice"+"\n"+"6 for discount"+"\n"+"7 for currentPrice");


    int choice = input_int.nextInt(); 




    



    
    

if(choice==1){
    for(Item item: itemList){

      String nameOfItem = item.getName();

      if(itemName.equals(nameOfItem)){
        System.out.println("what is the new category of the item"); 

        String newCat= input_string.nextLine();

        item.setCategory(newCat); 

        updateInventoryFile(); 
        
        

  
      }

      
      
    }
}

  if(choice==2){

    for(Item item: itemList){

      String nameOfItem = item.getName();

      if(itemName.equals(nameOfItem)){
        System.out.println("what is the new minimumquantitiy of the item"); 

       int newminQuant= input_int.nextInt();

        item.setMinQuantity(newminQuant); 

        updateInventoryFile(); 


    
  }

  }
  }



    if(choice==3){


      for(Item item: itemList){

      String nameOfItem = item.getName();

      if(itemName.equals(nameOfItem)){
        System.out.println("what is the new markupPercentage of the item"); 

       Double newvendPrice= input_double.nextDouble();

        item.setVendorPrice(newvendPrice); 

        updateInventoryFile(); 


      
    }


 

    
  }
    
  
  
}


    if(choice==4){
      for(Item item: itemList){

      String nameOfItem = item.getName();

      if(itemName.equals(nameOfItem)){
        System.out.println("what is the new markupPercentage of the item"); 

       int newMarkupPercentage= input_int.nextInt();

        item.setMarkupPercentage(newMarkupPercentage);

        updateInventoryFile(); 

      
    }
     } 
     }



    if(choice==5){
      for(Item item: itemList){

      String nameOfItem = item.getName();

      if(itemName.equals(nameOfItem)){
        System.out.println("what is the new regularPrice of the item"); 

       Double newRegularPrice= input_double.nextDouble();

        item.setRegularPrice(newRegularPrice);

        updateInventoryFile(); 

      
    }
     } 
     }




    if(choice==6){
      for(Item item: itemList){

      String nameOfItem = item.getName();

      if(itemName.equals(nameOfItem)){
        System.out.println("what is the new discount of the item"); 

       int newDiscount= input_int.nextInt();

        item.setDiscount(newDiscount);

        updateInventoryFile(); 

      
    }
     } 
     }


     if(choice==7){
      for(Item item: itemList){

      String nameOfItem = item.getName();

      if(itemName.equals(nameOfItem)){
        System.out.println("what is the new currentPrice of the item"); 

       Double newCurrentPrice= input_double.nextDouble();

        item.setCurrentPrice(newCurrentPrice);

        updateInventoryFile(); 

      
    }
     } 
     }



   



    



    

              
  }

public void purchaseItems(){


    ArrayList<Item> cartItems = new ArrayList<Item>();
    ArrayList<Integer> quantities = new ArrayList<Integer>(); 

  
  

   Inventory inventory= new Inventory("inventory.txt");
 startLoop:while(true){System.out.println("1:add to cart"+"\n"+"2:checkout");
    Scanner input_int = new Scanner(System.in);
  
  Scanner input = new Scanner(System.in);

    int choice = input_int.nextInt();
try{
    if(choice==1){
       System.out.print("\033[H\033[2J");

      System.out.print("Choose item By: "+"\n"+"1: name"+"\n"+"2: SKU"+"\n"+"3:back"+"\n\n\n"+"enter your choice >>>");
      int descion = input_int.nextInt();


      if(descion==1){
        
        purchaseNameLoop:while(true){

        System.out.println("what is the name of your item");

        String name = input.nextLine();

          for(Item item: itemList){
            System.out.print(item.getName()); 

            String temp = item.getName();
            
            if(temp.equals(name)){

              System.out.print("\033[H\033[2J");


               System.out.print("Item:"+item.getSKU()+"\n"+" Name:"+" "+item.getName()+"\n"+" Category:"+" "+item.getCategory()+"\n"+" Stock:"+item.getQuantity()+"\n"+"Regular price:"+" "+"$"+item.getregularPrice()+"\n"+" Sales Price:"+" "+"$"+item.getCurrentPrice()+"\n"+" Sales Percentage:"+" "+item.getDiscount()+"%"+"\n\n"+"enter your quantitiy >>>");

              

            
         
              
             int quant = input_int.nextInt();


              int minQuant=item.getMinQuantity();

              int currentQuant = item.getQuantity();
              int checkQuant = currentQuant - quant; 

            
              

              if(checkQuant>minQuant){


              cartItems.add(item); 

              quantities.add(quant); 

              updateItemQuantity(temp, quant, false);

              continue startLoop; 
              }


            else{
              System.out.println("Invalid input insufficent quantitiy to support that purchase");
              
              continue purchaseNameLoop;
            }  
              
              
              
              
            }


            else{
             System.out.println("invalid input name not found");
             continue purchaseNameLoop;
               
           } 

            
          }

          
        }

        
      }


       else if(descion==2){
        
        purchaseSKULoop:while(true){

        System.out.println("what is the SKU of your item");

        String SKU = input.nextLine();

          for(Item item: itemList){

            String temp = item.getSKU();
            
            if(temp.equals(SKU)){

              System.out.print("\033[H\033[2J");

              System.out.println("Item:"+item.getSKU()+"\n"+" Name:"+" "+item.getName()+"\n"+" Category:"+" "+item.getCategory()+"\n"+" Stock:"+item.getQuantity()+" Regular price:"+" "+"$"+item.getregularPrice()+"Sales Price:"+" "+"$"+item.getCurrentPrice()+" Sales Percentage:"+" "+"$"+item.getDiscount()+"%"+"\n\n"+"enter your quantitiy >>>");



               int quant = input_int.nextInt();


              int minQuant=item.getMinQuantity();

              int currentQuant = item.getQuantity();
              int checkQuant = currentQuant - quant; 
              System.out.println(checkQuant);

             if(checkQuant>minQuant){


              cartItems.add(item); 

              quantities.add(quant); 

              updateItemQuantity(temp, quant, false);

              continue startLoop; 
              }


               else{
              System.out.println("Invalid input insufficent quantitiy to support that purchase");
              
              continue purchaseSKULoop;
            }  
              
              
            }

           else{
             System.out.println("invalid input SKU not found");
             continue purchaseSKULoop;
               
           } 
          }

          
        }

        
      }




      else if(descion==3){
        System.out.print("\033[H\033[2J");
        continue startLoop;
      }
      


}


    


    else if(choice==2){

      UserInterface.checkout(cartItems,quantities);
    }
}


  catch(InputMismatchException ex){
   System.out.print("\033[H\033[2J");  

   System.out.println("invalid input, must be a string"); 
   input.next();
  }
}
}} 
    




     
    
  
  






  

  
      
      
    

  



  


 

  
  
  

        

