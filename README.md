#Running the app

1. Clone the repo
2. Import pom.xml file
3. Download pom dependencies by doing mvn clean install
4. Create java run configuration by selecting  src/main/java/com/challenge/sort_pizza_order/PizzaOrder as main application
5. add "file_src_location" "file_dest_location" as program arguments
6. Run the application
7. The final sorted orders are written to output file mentioned in second program argument

#Assumptions made
1. Sorting is first done by "time" in descending order
2. After that the list is lexicographically sorted out by "Order"