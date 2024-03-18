# Shopping System

## Overview
The Shopping System is a simplified online marketplace application developed as part of the SE 540 course. 
It showcases the application of SOLID principles, design patterns, and modern software development practices. 
The system allows users to authenticate, browse a catalog of products, manage a shopping cart, place orders, and simulate payment processes, all within a console-based interface.

## Features
- **User Authentication**: Secure login and session management.
- **Product Browsing**: Access a catalog of various products.
- **Shopping Cart Management**: Add or remove products from a personal shopping cart.
- **Order Placement**: Review cart items and place orders.
- **Payment Simulation**: Simulate payment transactions without real financial exchanges.

## Prerequisites
To run the Shopping System, ensure you have the following installed:
- Java JDK 11 or higher
- Maven 3.6.0 or higher for dependency management
- Eclipse, IntelliJ IDEA, or any Java IDE (optional but recommended)

## Setup and Installation
1. **Clone the Repository**
    ```bash
    git clone https://github.com/<your-username>/shopping-system.git
    ```
    Replace `<your-username>` with your GitHub username.

2. **Navigate to Project Directory**
    ```bash
    cd shopping-system
    ```

3. **Build the Project with Maven**
    ```bash
    mvn clean install
    ```

4. **Run the Application**
    - Through an IDE: Import the project into your IDE and run the main class.
    - Via command line:
        ```bash
        java -cp target/shopping-system-1.0.jar com.yourname.shoppingsystem.Main
        ```

## Usage
After launching the Shopping System, follow the on-screen prompts to navigate through the application. Actions include logging in, browsing products, managing your shopping cart, and placing orders.

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a pull request.

## License
This project is licensed under the MIT License - see the [LIC ENSE.md](LICENSE.md) file for details.
