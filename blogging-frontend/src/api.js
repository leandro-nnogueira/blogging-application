import axios from 'axios'

const API_URL = 'http://localhost:8080/api/posts'

export const getPosts = () => axios.get(API_URL)

export const createPost = (postData) => axios.post(API_URL, postData)

export const updatePost = (postId, postData) => axios.put(`${API_URL}/${postId}`, postData)

export const deletePost = (postId) => axios.delete(`${API_URL}/${postId}`)