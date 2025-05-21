# AkashicPay SDK Example (Java / Maven)

This project demonstrates how to use the **AkashicPay SDK** in a Java Maven environment to interact with the Akashic ecosystem (testnet).

## 📋 Prerequisites

Before running this example, please complete the following steps:

1. **Install AkashicLink and Create a Wallet**  
   Visit [AkashicLink](https://testnet.akashiclink.com) and create a wallet.

2. **Register as a Business Partner on AkashicPay**  
   Go to [AkashicPay Testnet Site](https://testnet.akashicpay.com) and register your account as a Business Partner.

3. **Generate a Secondary Key and API Secret**  
   After registering, generate a **secondary key** and **API secret** from the AkashicPay site.

4. **Configure Environment Variables**  
   Set the following values in a `.env` file or export them as environment variables, depending on how the example project is configured:

   ```env
   identity=your_wallet_identity_address
   private_key=your_secondary_key
   api_secret=your_api_secret
   ```

5. **Run the Example Program**  
   Once the environment variables are set, build and run the project using Maven:

   ```bash
   mvn clean install
   mvn exec:java
   ```

   > *Note: Make sure the `exec-maven-plugin` is configured properly in your `pom.xml`.*

## 📦 Installation

To clone and build the project:

```bash
git clone https://github.com/your-org/akashicpay-sdk-java-example.git
cd akashicpay-sdk-java-example
mvn clean install
```

## ⚙️ Environment Configuration

The project expects the following environment variables:

- `identity`: Your Wallet's L2 Address (Identity)
- `private_key`: Secondary key from AkashicPay
- `api_secret`: API secret from AkashicPay

You can either:

- Define them in a `.env` file and load them programmatically (e.g., using [dotenv-java](https://github.com/cdimascio/dotenv-java)), or
- Set them in your terminal:

```bash
export identity=your_wallet_identity_address
export private_key=your_secondary_key
export api_secret=your_api_secret
```

## 🔁 Callback URL Setup

You can register your **Callback URL** from the AkashicPay Business Partner Dashboard:  
[https://testnet.akashicpay.com](https://testnet.akashicpay.com)

Once registered, AkashicPay will send HTTP callbacks (webhooks) to your endpoint for the following event types:

- `pending-payout`:  
  A payout request has been received and is pending confirmation.

- `payout`:  
  The payout has been successfully processed and completed.

- `failed-payout`:  
  The payout process failed due to an error or rejection.

- `pending-deposit`:  
  A deposit has been initiated but is not yet confirmed.

- `deposit`:  
  The deposit has been confirmed and credited successfully.

- `failed-deposit`:  
  The deposit failed due to an error or invalid transaction.

> 🔐 **Security Note:**  
> You should verify the authenticity of callback requests by checking their signature or HMAC, depending on AkashicPay's webhook guidelines.

## ▶️ Running the Example

```bash
mvn exec:java
```

This will run the sample logic demonstrating the usage of AkashicPay SDK — such as creating a payment, checking balance, or authenticating requests.

## 📚 Documentation

If available, full SDK documentation can be found at:  
[https://docs.akashicpay.com](https://docs.akashicpay.com) *(replace with actual link if different)*

## 🔒 Security Notice

- This project is built for **testnet** usage.
- Do not share your `SECONDARY_KEY` or `API_SECRET`.
- Make sure `.env` or other credential files are added to `.gitignore`.

## 🛠 Troubleshooting

- Check that all required environment variables are set correctly.
- Make sure you're registered as a Business Partner.
- Use testnet resources only — mainnet is not supported in this example.

## 📬 Contact

For any questions or issues, feel free to reach out to the AkashicPay team or open an issue in this repository.