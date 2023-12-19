def encrypt_message(message, key):
    message = message.replace(" ", "").upper()
    columns = ['' for _ in range(key)]

    col = 0
    for char in message:
        columns[col] += char
        col = (col + 1) % key

    max_length = max(len(column) for column in columns)

    for i in range(max_length):
        for j in range(key):
            if i < len(columns[j]):
                print("           ", columns[j][i], end="\t")
            else:
                print(" ", end="\t")
        print()

    encrypted_message = ''.join(columns)
    return encrypted_message

def decrypt_message(encrypted_message, key):
    rows = len(encrypted_message) // key
    columns = [list(encrypted_message[i * rows:(i + 1) * rows]) for i in range(key)]

    original_message = ''
    for i in range(rows):
        for j in range(key):
            original_message += columns[j][i]

    return original_message

def display_tabular_message(message, key):
    columns = ['' for _ in range(key)]

    col = 0

    for char in message:
        columns[col] += char
        col = (col + 1) % key

    max_length = max(len(column) for column in columns)

    for i in range(max_length):
        for j in range(key):
            if i < len(columns[j]):
                print("           ", columns[j][i], end="\t")
            else:
                print(" ", end="\t")
        print()

def main():
    print("\n \n   ")
    print("-----------Simple Columnar Transposition Cipher-----------")

    while True:
        print("\n           Options:")
        print("           1. Encrypt a message")
        print("           2. Decrypt a message")
        print("           3. Quit")
        choice = input("           Enter your choice: ")

        if choice == '1':
            message = input("           Enter the message to encrypt: ")
            key = int(input("           Enter the key: "))
            print("\n           Display the Simple Columnar Working:")
            print("\n           Tabular Representation of Encrypted Message:\n")
            encrypted_message = encrypt_message(message, key)
            print("\n           Encrypted Message:", encrypted_message)

        elif choice == '2':
            encrypted_message = input("           Enter the message to decrypt: ")
            key = int(input("           Enter the key: "))
            decrypted_message = decrypt_message(encrypted_message, key)
            print("\n           Display the Simple Columnar Working:")
            print("\n           Tabular Representation of Decrypted Message:\n")
            display_tabular_message(decrypted_message, key)
            print("\n           Decrypted Message:", decrypted_message)

        elif choice == '3':
            print("\n\n-----------Thank You ! Goodbye !-----------\n\n")
            break

        else:
            print("           Invalid choice. Please enter 1, 2, or 3.")

if __name__ == "__main__":
    main()
