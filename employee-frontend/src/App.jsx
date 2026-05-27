import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [employees, setEmployees] = useState([]);
  const [attendance, setAttendance] = useState([]);

  const [employeeData, setEmployeeData] = useState({
    name: "",
    email: "",
    departmentId: ""
  });

  const [attendanceData, setAttendanceData] = useState({
    employeeId: "",
    date: "",
    status: "PRESENT"
  });

  const BASE_URL = "http://localhost:8089";

  // Fetch Employees
  const fetchEmployees = async () => {
    const response = await axios.get(`${BASE_URL}/employees`);
    setEmployees(response.data);
  };

  // Create Employee
  const createEmployee = async () => {
    const payload = {
      name: employeeData.name,
      email: employeeData.email,
      department: {
        id: employeeData.departmentId
      }
    };

    await axios.post(`${BASE_URL}/employees`, payload);
    fetchEmployees();

    setEmployeeData({
      name: "",
      email: "",
      departmentId: ""
    });
  };

  // Mark Attendance
  const markAttendance = async () => {
    const payload = {
      date: attendanceData.date,
      status: attendanceData.status,
      employee: {
        id: attendanceData.employeeId
      }
    };

    await axios.post(`${BASE_URL}/attendance`, payload);
    alert("Attendance Marked");
  };

  // Get Attendance
  const getAttendance = async (employeeId) => {
    const response = await axios.get(`${BASE_URL}/attendance/${employeeId}`);
    setAttendance(response.data);
  };

  useEffect(() => {
    fetchEmployees();
  }, []);

  return (
    <div className="app">
      <header className="hero">
        <div className="hero__content">
          <span className="eyebrow">People Ops</span>
          <h1>Employee Management</h1>
          <p className="subtitle">
            Track profiles and attendance with a clean, fast workspace built for
            daily check-ins.
          </p>

          <div className="stats">
            <div className="stat">
              <span className="stat__label">Employees</span>
              <span className="stat__value">{employees.length}</span>
            </div>
            <div className="stat">
              <span className="stat__label">Attendance Records</span>
              <span className="stat__value">{attendance.length}</span>
            </div>
          </div>
        </div>

        <div className="hero__panel">
          <h2>Quick steps</h2>
          <p className="muted">
            Add a teammate, then log today&apos;s status in a couple of clicks.
          </p>
          <div className="pill-group">
            <span className="pill">Create Employee</span>
            <span className="pill">Mark Attendance</span>
            <span className="pill">Review History</span>
          </div>
        </div>
      </header>

      <main className="content-grid">
        <section className="card">
          <div className="card__header">
            <div>
              <h2>Create Employee</h2>
              <p className="muted">Add new teammate records with department IDs.</p>
            </div>
          </div>

          <div className="form-grid">
            <label className="field">
              <span className="field__label">Full name</span>
              <input
                type="text"
                placeholder="e.g. Anuj Chandrakar"
                value={employeeData.name}
                onChange={(e) =>
                  setEmployeeData({
                    ...employeeData,
                    name: e.target.value
                  })
                }
              />
            </label>

            <label className="field">
              <span className="field__label">Email</span>
              <input
                type="email"
                placeholder="anuj.chandrakar99@gmail.com  "
                value={employeeData.email}
                onChange={(e) =>
                  setEmployeeData({
                    ...employeeData,
                    email: e.target.value
                  })
                }
              />
            </label>

            <label className="field">
              <span className="field__label">Department ID</span>
              <input
                type="number"
                placeholder="101"
                value={employeeData.departmentId}
                onChange={(e) =>
                  setEmployeeData({
                    ...employeeData,
                    departmentId: e.target.value
                  })
                }
              />
            </label>
          </div>

          <button className="btn btn--primary" onClick={createEmployee}>
            Add Employee
          </button>
        </section>

        <section className="card">
          <div className="card__header">
            <div>
              <h2>Mark Attendance</h2>
              <p className="muted">Log a daily status for any employee ID.</p>
            </div>
          </div>

          <div className="form-grid">
            <label className="field">
              <span className="field__label">Employee ID</span>
              <input
                type="number"
                placeholder="Employee ID"
                value={attendanceData.employeeId}
                onChange={(e) =>
                  setAttendanceData({
                    ...attendanceData,
                    employeeId: e.target.value
                  })
                }
              />
            </label>

            <label className="field">
              <span className="field__label">Date</span>
              <input
                type="date"
                value={attendanceData.date}
                onChange={(e) =>
                  setAttendanceData({
                    ...attendanceData,
                    date: e.target.value
                  })
                }
              />
            </label>

            <label className="field">
              <span className="field__label">Status</span>
              <select
                value={attendanceData.status}
                onChange={(e) =>
                  setAttendanceData({
                    ...attendanceData,
                    status: e.target.value
                  })
                }
              >
                <option>PRESENT</option>
                <option>ABSENT</option>
              </select>
            </label>
          </div>

          <button className="btn btn--primary" onClick={markAttendance}>
            Mark Attendance
          </button>
        </section>

        <section className="card card--list">
          <div className="card__header">
            <div>
              <h2>Employees</h2>
              <p className="muted">Tap an employee to load attendance history.</p>
            </div>
          </div>

          <div className="list">
            {employees.length === 0 ? (
              <p className="empty-state">No employees yet.</p>
            ) : (
              employees.map((emp) => (
                <div className="employee-card" key={emp.id}>
                  <div>
                    <h3 className="employee-card__name">{emp.name}</h3>
                    <p className="muted">{emp.email}</p>
                    <p className="meta">
                      Department: <span>{emp.department?.departmentName || "Unassigned"}</span>
                    </p>
                  </div>

                  <button
                    className="btn btn--ghost"
                    onClick={() => getAttendance(emp.id)}
                  >
                    View Attendance
                  </button>
                </div>
              ))
            )}
          </div>
        </section>

        <section className="card card--list">
          <div className="card__header">
            <div>
              <h2>Attendance</h2>
              <p className="muted">Latest records for the selected employee.</p>
            </div>
          </div>

          <div className="list">
            {attendance.length === 0 ? (
              <p className="empty-state">No attendance records yet.</p>
            ) : (
              attendance.map((entry) => (
                <div className="attendance-card" key={entry.id}>
                  <div>
                    <p className="meta">Date</p>
                    <p className="attendance-card__date">{entry.date}</p>
                  </div>
                  <span
                    className={`status-pill status-pill--${entry.status.toLowerCase()}`}
                  >
                    {entry.status}
                  </span>
                </div>
              ))
            )}
          </div>
        </section>
      </main>
    </div>
  );
}

export default App;