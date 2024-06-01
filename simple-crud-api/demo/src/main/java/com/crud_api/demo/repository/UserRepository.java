package com.crud_api.demo.repository;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.crud_api.demo.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Repository
public class UserRepository {
	 public static final String COLLECTION_NAME = "users";
	 
	 public String saveUser(User user) throws ExecutionException, InterruptedException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<com.google.cloud.firestore.WriteResult> collectionsApiFuture = 
	            dbFirestore.collection(COLLECTION_NAME).document(user.getId()).set(user);
	        return collectionsApiFuture.get().getUpdateTime().toString();
	    }

	    public User getUserById(String id) throws ExecutionException, InterruptedException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        return  dbFirestore.collection(COLLECTION_NAME).document(id).get().get().toObject(User.class);
	    }

	    public String updateUser(User user) throws ExecutionException, InterruptedException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<com.google.cloud.firestore.WriteResult> collectionsApiFuture = 
	            dbFirestore.collection(COLLECTION_NAME).document(user.getId()).set(user);
	        return "User Updated Successful " +collectionsApiFuture.get().getUpdateTime().toString();
	    }

	    public String deleteUser(String id) throws ExecutionException, InterruptedException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<com.google.cloud.firestore.WriteResult> writeResult = 
	            dbFirestore.collection(COLLECTION_NAME).document(id).delete();
	        return "Document with ID " + id + " has been deleted";
	    }

	    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).get();
	        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
	        return documents.stream().map(document -> document.toObject(User.class)).collect(Collectors.toList());
	    }

}
