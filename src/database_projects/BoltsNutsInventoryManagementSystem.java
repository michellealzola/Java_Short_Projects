package database_projects;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoltsNutsInventoryManagementSystem extends Application
{
	private MenuBar menuBar;
	private Menu fileMenu;
	private MenuItem exitMenuItem;
	
	// Create menu
	private Menu createMenu;
	
	private MenuItem productAdd;
	private Label addProductLabel;
	private Label productIDLabel;
	private Label productNameLabel;
	private Label productDescriptionLabel;
	private Label categoryIDLabel;
	private TextField productIDTextField;
	private TextField productNameTextField;
	private TextField productDescriptionTextField;
	private TextField categoryIDTextField;
	private HBox productIDHBox;
	private HBox productNameHBox;
	private HBox productDescriptionHBox;
	private HBox categoryIDHBox;
	private VBox addProductVBox;
	private Button addProductButton;
	private Label addProductMsg;
	
	private MenuItem inventoryAdd;
	private Label addInventoryLabel;
	private Label inventoryIDLabel;
	private Label inProductIDLabel;
	private Label supplierIDLabel;
	private Label qtyInStockLabel;
	private TextField inventoryIDTextField;
	private TextField inProductIDTextField;
	private TextField supplierIDTextField;
	private TextField qtyInStockTextField;
	private HBox inventoryIDHBox;
	private HBox inProductIDHBox;
	private HBox supplierIDHBox;
	private HBox qtyInStockHBox;
	private VBox addInventoryVBox;
	private Button addInventoryButton;
	private Label addInventoryMsg;
	
	
	
	private MenuItem categoryAdd;
	private MenuItem supplierAdd;	
	
	
	
	// Read menu
	private Menu readMenu;
	private MenuItem productMenuItem;
	private MenuItem inventoryMenuItem;
	private MenuItem categoryMenuItem;
	private MenuItem supplierMenuItem;	
	private ListView<String> itemListView;
	private VBox readVBox;
	
	private Menu updateMenu;
	private Menu deleteMenu;
	
	private BorderPane borderPane;
	
	public static void main(String[] args)
	{
		Application.launch(args);

	}
	
	@Override
	public void start(Stage primaryStage)
	{
		menuBar = new MenuBar();
		buildFileMenu(primaryStage);
		buildCreateMenu(primaryStage);
		buildReadMenu(primaryStage);
		buildUpdateMenu(primaryStage);
		buildDeleteMenu(primaryStage);
		
		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(createMenu);
		menuBar.getMenus().add(readMenu);
		menuBar.getMenus().add(updateMenu);
		menuBar.getMenus().add(deleteMenu);
		
		borderPane = new BorderPane();
		borderPane.setTop(menuBar);

		readMenu.setOnAction(e2 -> 
		{
			borderPane.setCenter(readVBox);
		});
		
		
		Scene scene = new Scene(borderPane, 1000, 500);
		scene.getStylesheets().add("nuts_bolts.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();		
		
	}

	private void buildCreateMenu(Stage primaryStage)
	{
		createMenu = new Menu("Create");
	    productAdd = new MenuItem("Add Product");
	    inventoryAdd = new MenuItem("Add Inventory");
	    categoryAdd = new MenuItem("Add Category");
	    supplierAdd = new MenuItem("Add Supplier");

	    createMenu.getItems().add(productAdd);
	    createMenu.getItems().add(inventoryAdd);
	    createMenu.getItems().add(categoryAdd);
	    createMenu.getItems().add(supplierAdd);
	    
	    // Add Product
	    addProductLabel = new Label("Add a Product");
	    addProductLabel.getStyleClass().add("heading");
	    
	    productIDLabel = new Label("Product ID:");
	    productIDTextField = new TextField();
	    productIDHBox = new HBox(10, productIDLabel, productIDTextField);
	    
	    productNameLabel = new Label("Product Name:");
	    productNameTextField = new TextField();
	    productNameHBox = new HBox(10, productNameLabel, productNameTextField);
	    
	    productDescriptionLabel = new Label("Product Description:");
	    productDescriptionTextField = new TextField();
	    productDescriptionHBox = new HBox(10, productDescriptionLabel, productDescriptionTextField);
	    
	    categoryIDLabel = new Label("Category ID:");
	    categoryIDTextField = new TextField();
	    categoryIDHBox = new HBox(10, categoryIDLabel, categoryIDTextField);
	    
	    addProductMsg = new Label();
	    
	    addProductButton = new Button("Add Product");
	    addProductButton.setOnAction(eAddProductButton -> 
	    {
	    	try
			{
				addProductMsg.setText(BoltsNutsInventoryDBManager.addProduct(productIDTextField.getText(), 
						productNameTextField.getText(), productDescriptionTextField.getText(), 
						categoryIDTextField.getText()));
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    		
	    addProductVBox = new VBox(10, addProductLabel, productIDHBox, productNameHBox, productDescriptionHBox, categoryIDHBox, addProductButton, addProductMsg);
	    addProductVBox.setPadding(new Insets(25));
	    
	    productAdd.setOnAction(e -> {
	        borderPane.setCenter(addProductVBox);
	    });
	    
	    // Add Inventory
	    addInventoryLabel = new Label("Add an Inventory");
	    addInventoryLabel.getStyleClass().add("heading");
	    
	    inventoryIDLabel = new Label("Inventory ID:");
	    inventoryIDTextField = new TextField();
	    inventoryIDHBox = new HBox(10, inventoryIDLabel, inventoryIDTextField);
	    
	    inProductIDLabel = new Label("Product ID: ");
	    inProductIDTextField = new TextField();
	    inProductIDHBox = new HBox(10, inProductIDLabel, inProductIDTextField);
	    
	    supplierIDLabel = new Label("Supplier ID:");
	    supplierIDTextField = new TextField();
	    supplierIDHBox = new HBox(10, supplierIDLabel, supplierIDTextField);
	    
	    qtyInStockLabel = new Label("Quantity in Stock");
	    qtyInStockTextField = new TextField();
	    qtyInStockHBox = new HBox(10, qtyInStockLabel, qtyInStockTextField);
	    
	    addInventoryMsg = new Label();
	    
	    addInventoryButton = new Button("Add Inventory");
	    addInventoryButton.setOnAction(eAddInventoryButton -> 
	    {
	    	try
			{
				addInventoryMsg.setText(BoltsNutsInventoryDBManager.addInventory(inventoryIDTextField.getText(), inProductIDTextField.getText(), supplierIDTextField.getText(), Integer.parseInt(qtyInStockTextField.getText())));
			} 
	    	catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    
	    addInventoryVBox = new VBox(10, addInventoryLabel, inventoryIDHBox, inProductIDHBox, supplierIDHBox, qtyInStockHBox, addInventoryButton, addInventoryMsg);
		addInventoryVBox.setPadding(new Insets(25));
		
		inventoryAdd.setOnAction(e -> {
	        borderPane.setCenter(addInventoryVBox);
	    });
		
		// Add Category
		
		
	}


	private void buildReadMenu(Stage primaryStage)
	{
		readMenu = new Menu("Read");
		productMenuItem = new MenuItem("View Products");
		inventoryMenuItem = new MenuItem("View Inventory");
		categoryMenuItem = new MenuItem("View Categories");
		supplierMenuItem = new MenuItem("View Suppliers");		
		
		readMenu.getItems().add(productMenuItem);
		readMenu.getItems().add(inventoryMenuItem);
		readMenu.getItems().add(categoryMenuItem);
		readMenu.getItems().add(supplierMenuItem);		
		
		itemListView = new ListView<>();
		itemListView.setPrefHeight(1000);
		
		productMenuItem.setOnAction(e ->
		{
			try
			{
				itemListView.getItems().addAll(BoltsNutsInventoryDBManager.getProductList());
				
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		inventoryMenuItem.setOnAction(e ->
		{
			
			try
			{
				itemListView.getItems().addAll(BoltsNutsInventoryDBManager.getInventoryList());
				
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		categoryMenuItem.setOnAction(e ->
		{
			
			try
			{
				itemListView.getItems().addAll(BoltsNutsInventoryDBManager.getCategoryList());
				
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		supplierMenuItem.setOnAction(e ->
		{
			
			try
			{
				itemListView.getItems().addAll(BoltsNutsInventoryDBManager.getSupplierList());
				
			} 
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});		

		readVBox = new VBox(itemListView);
		readVBox.setPadding(new Insets(15));
		
	}

	private void buildUpdateMenu(Stage primaryStage)
	{
		updateMenu = new Menu("Update");
		
	}

	private void buildDeleteMenu(Stage primaryStage)
	{
		deleteMenu = new Menu("Delete");
		
	}

	private void buildFileMenu(Stage primaryStage)
	{
		fileMenu = new Menu("File");
		exitMenuItem = new MenuItem("Exit");
		
		exitMenuItem.setOnAction(event -> 
		{
			primaryStage.close();
		});
		
		fileMenu.getItems().add(exitMenuItem);
	}

}
