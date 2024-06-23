# Food Ordering System API

# Overview

This API provides a set of RESTful endpoints for managing users, restaurants, food items, and orders in a food ordering system.

#Endpoints

# User Management

- POST /users: Create a new user (customer or restaurant owner)
- POST /users/login: Login a user
- GET /users/{id}: Get a user's profile
- PUT /users/{id}: Update a user's profile
- DELETE /users/{id}: Delete a user

# Restaurant Management

- POST /restaurants: Create a new restaurant (only accessible by restaurant owners)
- GET /restaurants: Get a list of all restaurants
- GET /restaurants/{id}: Get a restaurant's details
- PUT /restaurants/{id}: Update a restaurant's details (only accessible by restaurant owners)
- DELETE /restaurants/{id}: Delete a restaurant (only accessible by restaurant owners)

# Food Item Management

- restaurants/{id}/food-items: Add a new food item to a restaurant (only accessible by restaurant owners)
- restaurants/{id}/food-items: Get a list of food items for a restaurant
- food-items/{id}: Get a food item's details
- food-items/{id}: Update a food item's details (only accessible by restaurant owners)
- food-items/{id}: Delete a food item (only accessible by restaurant owners)

# Order Management

- orders: Place a new order (only accessible by customers)
- orders: Get a list of all orders (only accessible by customers)
- orders/{id}: Get an order's details
- orders/{id}: Update an order's status (only accessible by restaurant owners)
- orders/{id}: Delete an order (only accessible by customers)


# Models

- User: { id, name, email, password, role (customer or restaurant owner) }
- Restaurant: { id, name, address, owner_id 
- FoodItem: { id, name, description, price, availability, restaurant_id 
- Order: { id, customer_id (foreign key to User), restaurant_id , order_status
