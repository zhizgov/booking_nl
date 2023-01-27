import {useEffect, useState} from "react";
import {over} from 'stompjs';
import SockJS from 'sockjs-client';
import '../index.css';
import jwtDecode from "jwt-decode";

let stompClient = null;

export default function ChatService() {
    const [privateChats, setPrivateChats] = useState(new Map());
    const [publicChats, setPublicChats] = useState([]);
    const [tab,setTab] =useState("CHATROOM");
    const [userData, setUserData] = useState({
        username: jwtDecode(sessionStorage.getItem("accessToken")).sub,
        receivername: '',
        connected: false,
        message: ''
    });
    useEffect(() => {

        connect();

    }, []);

    const connect =()=>{
        let socket = new SockJS('http://localhost:8080/ws');
        stompClient = over(socket);
        stompClient.connect({},onConnected, onError);
    }

    const onConnected = () => {
        setUserData({...userData,"connected": true});
        stompClient.subscribe('/chatroom/public', onMessageReceived);
        userJoin();
    }

    const userJoin=()=>{
          var chatMessage = {
            senderName: userData.username,
            status:"JOIN"
          };
          stompClient.send("/app/message", {}, JSON.stringify(chatMessage));
    }

    const onMessageReceived = (payload)=>{
        console.log(payload);
        var payloadData = JSON.parse(payload.body);
        switch(payload.command){
            case "JOIN":
               
                break;
            case "MESSAGE":
                if(payloadData.message === null){
                    setUserData(prevState => ({...prevState, message: ""}))
                }
                publicChats.push(payloadData);
                setPublicChats([...publicChats]);
                break;
        }
    }
    
    


    const onError = (err) => {
        console.log(err);
    }

    const handleMessage =(event)=>{
        const {value}=event.target;
        setUserData({...userData,"message": value});
    }
    const sendValue=()=>{
        if (stompClient) {
            var chatMessage = {
                senderName: userData.username,
                receiverName:tab,
                message: userData.message,
                status:"MESSAGE"
            };
            stompClient.send("/app/message", {}, JSON.stringify(chatMessage));
            publicChats.push(chatMessage);
            setUserData({...userData,"message": ""});
        }
    }

   

    // const handleUsername=(username)=>{
    //     setUserData({...userData,"username": username });
    // }

    return (
        <div className="container">
                <div className="chat-box">
                    <div className="member-list">
                        <ul>
                            <li onClick={()=>{setTab("CHATROOM")}} className={`member ${tab==="CHATROOM" && "active"}`}>Chatroom</li>
                            {[...privateChats.keys()].map((name,index)=>(
                                <li onClick={()=>{setTab(name)}} className={`member ${tab===name && "active"}`} key={index}>{name}</li>
                            ))}
                        </ul>
                    </div>
                    {tab==="CHATROOM" && <div className="chat-content">
                        <ul className="chat-messages">
                            {publicChats.map((chat,index)=>(
                                <li className={`message ${chat.senderName === userData.username && "self"}`} key={index}>
                                    {chat.senderName !== userData.username && <div className="avatar">{chat.senderName}</div>}
                                    <div className="message-data">{chat.message}</div>
                                    {chat.senderName === userData.username && <div className="avatar self">{chat.senderName}</div>}
                                    
                                </li>
                            ))}
                        </ul>

                        <div className="send-message">
                            <input type="text" className="input-message" placeholder="enter the message" value={userData.message} onChange={handleMessage} />
                            <button type="button" className="send-button" onClick={sendValue}>send</button>
                        </div>
                    </div>}
                    {/* {tab!=="CHATROOM" && <div className="chat-content">
                        <ul className="chat-messages">
                            {[...privateChats.get(tab)].map((chat,index)=>(
                                <li className={`message ${chat.senderName === userData.username && "self"}`} key={index}>
                                    {chat.senderName !== userData.username && <div className="avatar">{chat.senderName}</div>}
                                    <div className="message-data">{chat.message}</div>
                                    {chat.senderName === userData.username && <div className="avatar self">{chat.senderName}</div>}
                                </li>
                            ))}
                        </ul>

                        <div className="send-message">
                            <input type="text" className="input-message" placeholder="enter the message" value={userData.message} onChange={handleMessage} />
                            <button type="button" className="send-button" onClick={sendPrivateValue}>send</button>
                        </div>
                    </div>} */}
                </div>
        </div>
    )
}