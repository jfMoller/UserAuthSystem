// calls.js
import axios from "axios";

const baseUrl = "http://localhost:8080/api";

export async function callGet(endpoint) {
  try {
    const response = await axios.get(baseUrl + endpoint);
    return response.data;
  } catch (error) {
    console.error("Error fetching data:", error);
  }
}

export async function callPost(endpoint, data) {
  try {
    const response = await axios.post(baseUrl + endpoint, data);
    return response.data;
  } catch (error) {
    console.error("Error posting data:", error);
  }
}


