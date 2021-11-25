package com.example.getmesocialservice.Service;


import com.example.getmesocialservice.model.FirebaseUser;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class FirebaseService {

    public FirebaseUser auth(String idToken) throws IOException, FirebaseAuthException {
       String uid= FirebaseAuth.getInstance().verifyIdToken(idToken).getUid();
       String name= FirebaseAuth.getInstance().verifyIdToken(idToken).getName();
       String email= FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();

       return new FirebaseUser(uid,name,email);
    }
}
