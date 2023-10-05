# Chating_Between_Peers

In this project, we aim to create a versatile chat application that leverages both UDP (User Datagram Protocol) and TCP (Transmission Control Protocol) socket programming. The application will serve as a platform for users to engage in real-time conversations and exchange text files seamlessly.

<img width="1043" alt="Screen Shot 2023-10-05 at 6 59 16 AM" src="https://github.com/MoheeQwareeq/Peers_Chating/assets/143301303/d99f4aac-6b46-459a-981c-57c75ff54484">

UDP for Peer-to-Peer Chatting

For the core chatting functionality, we will implement UDP socket programming. UDP is well-suited for peer-to-peer communication, allowing users to exchange messages directly with one another. This approach ensures low-latency, efficient communication between clients.

Peer-to-Peer Chat Communication

It's important to note that despite the central role of the TCP server in managing active clients, the actual chat communication remains peer-to-peer. Clients will communicate directly with one another for their conversations, ensuring privacy and direct interaction between users.

File Sharing Capabilities

In addition to text-based chat, our application will empower users to send ".txt" files to each other. This feature enhances the utility of the application, enabling users to exchange documents and share information seamlessly.



<img width="1037" alt="Screen Shot 2023-10-05 at 6 59 26 AM" src="https://github.com/MoheeQwareeq/Peers_Chating/assets/143301303/1893f00c-5343-4d78-ae71-b62c000c2b2b">



TCP for Managing Active Clients

To manage the list of active chat clients and facilitate communication, we will use TCP socket programming. The TCP server will act as a central hub, keeping track of the clients currently engaged in chat sessions. It will also provide a list of active clients to other clients when requested.

Server's Role in Sharing Active Client List

The TCP server's primary role is to maintain a dynamic list of active clients. When a new client connects or an existing one leaves, the server updates this list accordingly. Additionally, the server will respond to client requests by providing an up-to-date list of active clients. This functionality mirrors the behavior seen in popular chat applications like Skype.

<img width="741" alt="Screen Shot 2023-10-05 at 6 59 00 AM" src="https://github.com/MoheeQwareeq/Peers_Chating/assets/143301303/5f6db3fa-fd67-4fbb-97d5-9ae509d79178">
